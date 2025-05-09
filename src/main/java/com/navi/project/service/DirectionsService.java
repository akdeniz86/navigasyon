package com.navi.project.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.navi.project.config.GeometryDecoder;
import com.navi.project.dto.DirectionsResponseDTOs.DirectionsResponseDTO;
import com.navi.project.dto.ORSDirectionsRequestDTOs.ORSDirectionsRequestDTO;
import com.navi.project.dto.ORSDirectionsResponseDTOs.Extras;
import com.navi.project.dto.ORSDirectionsResponseDTOs.ORSDirectionsResponseDTO;
import com.navi.project.dto.ORSDirectionsResponseDTOs.Route;
import com.navi.project.dto.ORSDirectionsResponseDTOs.Segment;
import com.navi.project.dto.ORSDirectionsResponseDTOs.Step;
import com.navi.project.dto.ORSDirectionsResponseDTOs.Tollways;
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
	

	public Mono<DirectionsResponseDTO> calculateRoute(ORSDirectionsRequestDTO oRSDirectionsRequestDTO) {
		return webClient.post()
				.uri(directionsUri)
				.header("Authorization", apiKey)
				.bodyValue(oRSDirectionsRequestDTO).retrieve()
				.bodyToMono(ORSDirectionsResponseDTO.class)
				.map(responseMap -> {
					List<Route> routes = responseMap.getRoutes();
					
					if (routes == null || routes.isEmpty()) {
						throw new RuntimeException("Rota bulunamadı.");
					}			
					
					Route route = responseMap.getRoutes().get(0);
					List<Segment> segments = route.getSegments();
					List<Step> steps = segments.get(0).getSteps();
				//	Extras extras = route.getExtras();		
					


					// yol tarifi  Talimatlarını liste yapıyoruz////////////////////					
					List<String> instructions = steps.stream()
						    .map(step -> {
						        String instruction = step.getInstruction();
						        Double distance = step.getDistance();
						        Double duration = step.getDuration();
						        return  instruction + " ( "+ distance + " km, " + duration +" sn )";
						    })
						    .collect(Collectors.toList());
					


					// Mesafe ve süre
					double distance = segments.get(0).getDistance();
					double duration = segments.get(0).getDuration();


					// Geometriyi string ifadeyi koordinat sistemine çevir
					String encodedGeometry = route.getGeometry();
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
	public String calculateTollFees(Route route, Map<String, Double> tollPrices) {
		List<Segment> segments = route.getSegments();
		List<Step> steps = segments.get(0).getSteps();
		Extras extras = route.getExtras();	
		Tollways tollways =extras.getTollways();
		List<List<Integer>> tollValues = tollways.getValues();
		
		StringBuilder result = new StringBuilder();
		Set<String> processedHighways = new HashSet<>();

		for (List<Integer> toll : tollValues) {
			Integer tollStart = (Integer) toll.get(0);
			Integer tollEnd = (Integer) toll.get(1);
			Integer isToll = (Integer) toll.get(2);

			if (isToll == 1) {
				double totalDistanceKiloMeters = 0.0;
				String highwayCode = null; // O- kodunu bulana kadar sakla

				for (Step step : steps) {
					List<Integer> wayPoints = step.getWay_points();
					Integer stepStart = wayPoints.get(0);
					Integer stepEnd = wayPoints.get(1);

					if (isInRange(stepStart, stepEnd, tollStart, tollEnd)) {
						totalDistanceKiloMeters += step.getDistance();
						String stepName = step.getName();
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
	////////////**************************///////////////////////
	private boolean isInRange(Integer stepStart, Integer stepEnd, Integer rangeStart, Integer rangeEnd) {
		// koordinat Adımının, ücretli bölümle çakışıp çakışmadığını kontrol et
		return Math.max(stepStart, rangeStart) <= Math.min(stepEnd, rangeEnd);
	}
	////////////**************************///////////////////////
	private String findHighwayCode(String name) {
		// "O-" ile başlayan otoyol kodunu bul
		if (name == null)
			return null; // Null kontrolü
		Pattern pattern = Pattern.compile("O-\\d+"); // Doğru regex
		Matcher matcher = pattern.matcher(name);
		return matcher.find() ? matcher.group() : null;
	}
	
}
