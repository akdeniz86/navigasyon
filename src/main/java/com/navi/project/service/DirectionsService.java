package com.navi.project.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.navi.project.config.GeometryDecoder;
import com.navi.project.dto.DirectionsRequestDTO;
import com.navi.project.dto.DirectionsResponseDTO;
import com.navi.project.model.TollBridges;
import com.navi.project.model.TollWays;
import com.navi.project.repo.TollBridgesRepository;
import com.navi.project.repo.TollWaysRepository;

import reactor.core.publisher.Mono;

@Service
public class DirectionsService {

	private final WebClient webClient;
	private final TollWaysRepository tollWaysRepository;
	private final TollBridgesRepository tollBridgesRepository;
	@Value("${ors.api.key}")
	private String apiKey;

	@Value("${ors.directions.uri}")
	private String directionsUri;
	
    public DirectionsService(WebClient.Builder webClientBuilder,
            TollWaysRepository tollWaysRepository, TollBridgesRepository tollBridgesRepository) {
    			this.webClient = webClientBuilder.build();
    			this.tollWaysRepository = tollWaysRepository;
    			this.tollBridgesRepository=tollBridgesRepository;
    	}
	

	public Mono<DirectionsResponseDTO> calculateRoute(DirectionsRequestDTO requestDTO) {
		return webClient.post().uri(directionsUri).header("Authorization", apiKey).bodyValue(requestDTO).retrieve()
				.bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {
				}).map(responseMap -> {
					List<Map<String, Object>> routes = (List<Map<String, Object>>) responseMap.get("routes");
					if (routes == null || routes.isEmpty()) {
						throw new RuntimeException("Rota bulunamadı.");
					}

					Map<String, Object> route = routes.get(0);
					List<Map<String, Object>> segments = (List<Map<String, Object>>) route.get("segments");
					List<Map<String, Object>> steps = (List<Map<String, Object>>) segments.get(0).get("steps");
					Map<String, Object> extras = (Map<String, Object>) route.get("extras");

					// yol tarifi  Talimatlarını liste yapıyoruz////////////////////					
					List<String> instructions = steps.stream()
						    .map(step -> {
						        String instruction = (String) Optional.ofNullable(step.get("instruction")).orElse("");
						        Double distance = (Double) Optional.ofNullable(step.get("distance")).orElse("");
						        Double duration = (Double) Optional.ofNullable(step.get("duration")).orElse("");						      					        
						        return  instruction + " ( "+ distance + " km, " + duration +" sn )";
						    })
						    .collect(Collectors.toList());
					


					// Mesafe ve süre
					double distance = ((Number) segments.get(0).get("distance")).doubleValue();
					double duration = ((Number) segments.get(0).get("duration")).doubleValue();

					// Geometriyi string ifadeyi koordinat sistemine çevir
					String encodedGeometry = (String) route.get("geometry");
					JSONArray coordinates = GeometryDecoder.decodeGeometry(encodedGeometry, false);
					List<List<Double>> geoCoord = new ArrayList<>();
					for (int i = 0; i < coordinates.length(); i++) {
						JSONArray point = coordinates.getJSONArray(i);
						geoCoord.add(List.of(point.getDouble(1), point.getDouble(0))); // [lat, lon]
					}

					// otoyolların ayrı ayrı ücret hesaplanması
					Map<String, Double> tollPrices = tollWaysRepository.findAll().stream()
							.collect(Collectors.toMap(TollWays::getHighwayCode, TollWays::getPrice));
					String allTollFees = calculateTollFees(route, tollPrices);
					
					// koordinat dizisinin köprüden geçiyormu sorgusu
					Set<String> tollBridgeList = new HashSet<>();

					for (List<Double> coord : geoCoord) {
					    String wkt = String.format(Locale.US, "POINT(%f %f)", coord.get(0), coord.get(1));
					    List<Object[]> results = tollBridgesRepository.findNearbyBridges(wkt, 1000.0);
					    for (Object[] row : results) {
					        String name = (String) row[0];
					        Double price = (Double) row[1];
					        tollBridgeList.add("Ve " + name + " ücreti: " + price + "₺");
					    }
					}
					

					// DTO oluştur RouteResponseDTO
					return new DirectionsResponseDTO(distance, duration, allTollFees, tollBridgeList, instructions,  geoCoord );
				});
	}

	/////////////// O- ile başlayan otoyol uzunluklarını tek tek topla ve
	/////////////// veritabanındaki fiyatı ile çarp hesapla////////////////////////
	public String calculateTollFees(Map<String, Object> route, Map<String, Double> tollPrices) {
		List<Map<String, Object>> segments = (List<Map<String, Object>>) route.get("segments");
		List<Map<String, Object>> steps = (List<Map<String, Object>>) segments.get(0).get("steps");

		Map<String, Object> extras = (Map<String, Object>) route.get("extras");
		Map<String, Object> tollways = (Map<String, Object>) extras.get("tollways");
		List<List<Object>> tollValues = (List<List<Object>>) tollways.get("values");

		StringBuilder result = new StringBuilder();
		Set<String> processedHighways = new HashSet<>();

		for (List<Object> toll : tollValues) {
			int tollStart = (int) toll.get(0);
			int tollEnd = (int) toll.get(1);
			int isToll = (int) toll.get(2);

			if (isToll == 1) {
				double totalDistanceKiloMeters = 0.0;
				String highwayCode = null; // O- kodunu bulana kadar sakla

				for (Map<String, Object> step : steps) {
					List<Integer> wayPoints = (List<Integer>) step.get("way_points");
					int stepStart = wayPoints.get(0);
					int stepEnd = wayPoints.get(1);

					if (isInRange(stepStart, stepEnd, tollStart, tollEnd)) {
						totalDistanceKiloMeters += ((Number) step.get("distance")).doubleValue();
						String stepName = (String) step.get("name");
						// O- kodunu bulmaya çalış
						if (highwayCode == null) {
							highwayCode = findHighwayCode(stepName);
						}
					}
				}

				if (totalDistanceKiloMeters > 0 && highwayCode != null && tollPrices.containsKey(highwayCode)
						&& !processedHighways.contains(highwayCode)) {

					double fee = tollPrices.get(highwayCode) * totalDistanceKiloMeters;
					result.append(String.format("%s Otoyolunda %.0f km yol için ücret %.2f₺, ", highwayCode,
							totalDistanceKiloMeters, fee));
					processedHighways.add(highwayCode);
				}
			}
		}

		if (result.length() > 0) {
			result.setLength(result.length() - 2); // Sondaki ", " kaldır
			result.append(" dir.");
		}

		return result.toString();
	}

	private boolean isInRange(int stepStart, int stepEnd, int rangeStart, int rangeEnd) {
		// koordinat Adımının, ücretli bölümle çakışıp çakışmadığını kontrol et
		return Math.max(stepStart, rangeStart) <= Math.min(stepEnd, rangeEnd);
	}

	private String findHighwayCode(String name) {
		// "O-" ile başlayan otoyol kodunu bul
		if (name == null)
			return null; // Null kontrolü
		Pattern pattern = Pattern.compile("O-\\d+"); // Doğru regex
		Matcher matcher = pattern.matcher(name);
		return matcher.find() ? matcher.group() : null;
	}
	
//	/// köprü metotu
//	 public List<String> findNearbyBridgeDescriptions(List<List<Double>> geoCoord, double distanceBridge) {
//	        // LINESTRING WKT oluştur
//	        StringBuilder sb = new StringBuilder("LINESTRING(");
//	        for (int i = 0; i < geoCoord.size(); i++) {
//	            List<Double> point = geoCoord.get(i);
//	            sb.append(point.get(0)).append(" ").append(point.get(1));
//	            if (i < geoCoord.size() - 1) sb.append(", ");
//	        }
//	        sb.append(")");
//	        String lineStringWKT = sb.toString();
//
//	        // Veritabanı sorgusu
//	       // List<Object[]> results = tollBridgesRepository.findNearbyBridgesFromLine(lineStringWKT, distanceBridge);
//
//	        // String ifadeye dönüştür
//	        //List<String> descriptions = new ArrayList<>();
//	        Set<String> descriptions = new HashSet<>();
//	        for (List<Double> coord : geoCoord) {
//	            String wkt = String.format("POINT(%f %f)", coord.get(0), coord.get(1));
//	            List<Object[]> results = tollBridgesRepository.findNearbyBridges(wkt, 100.0);
//	            for (Object[] row : results) {
//	                String name = (String) row[0];
//	                Double price = (Double) row[1];
//	                descriptions.add(name + " ücreti: " + price + "₺");
//	            }
//	        }
//
//	        return descriptions;
//	    }

}
