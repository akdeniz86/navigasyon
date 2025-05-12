package com.navi.project.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.navi.project.dto.DirectionsResponseDTOs.DirectionsResponseDTO;
import com.navi.project.dto.ORSDirectionsRequestDTOs.ORSDirectionsRequestDTO;
import com.navi.project.dto.ORSDirectionsResponseDTOs.Feature;
import com.navi.project.dto.ORSDirectionsResponseDTOs.ORSDirectionsResponseDTO;

import com.navi.project.dto.ORSDirectionsResponseDTOs.Segment;
import com.navi.project.dto.ORSDirectionsResponseDTOs.Step;

import com.navi.project.repo.RoadsRepository;
import com.navi.project.repo.TollBridgesRepository;

import reactor.core.publisher.Mono;

@Service
public class DirectionsService {

	private final WebClient webClient;

	private final TollBridgesRepository tollBridgesRepository;
    private final RoadsRepository roadsRepository;
    
	@Value("${ors.api.key}")
	private String apiKey;

	@Value("${ors.directions.uri}")
	private String directionsUri;

	public DirectionsService(WebClient.Builder webClientBuilder,RoadsRepository roadsRepository,
			TollBridgesRepository tollBridgesRepository) {
		this.webClient = webClientBuilder.build();

		this.tollBridgesRepository = tollBridgesRepository;
		this.roadsRepository = roadsRepository;
	}

	public Mono<DirectionsResponseDTO> calculateRoute(ORSDirectionsRequestDTO oRSDirectionsRequestDTO) {
		return webClient.post().uri(directionsUri).header("Authorization", apiKey).bodyValue(oRSDirectionsRequestDTO)
				.retrieve().bodyToMono(ORSDirectionsResponseDTO.class).map(responseMap -> {
					List<Feature> features = responseMap.getFeatures();

					if (features == null || features.isEmpty()) {
						throw new RuntimeException("Rota bulunamadı.");
					}

					Feature feature = responseMap.getFeatures().get(0);
					List<Segment> segments = feature.getProperties().getSegments();
					List<Step> steps = segments.get(0).getSteps();
					
					// Mesafe ve süre //////////////////////////
					double distance = segments.get(0).getDistance();
					double duration = segments.get(0).getDuration();
				
					// yol tarifi Talimatlarını liste yapıyoruz////////////////////
					List<List<Double>> instructions = steps.stream()
						    .map(step -> Arrays.asList(step.getDistance(), step.getDuration()))
						    .collect(Collectors.toList());
					
					List<List<Double>> geoCoords =feature.getGeometry().getCoordinates();		
					
					///////////////yeniyoll////////////////////////////////////////
					// RoadsRepository üzerinden sorgu çek ve kesişim uzunluğunu al
					Double intersectLength = calculateRoadIntersectionLength(geoCoords);
					String allTollFees = (intersectLength != null) ? intersectLength.toString() : "0.0"; 

					// koordinat dizisinin köprüden geçiyormu sorgusu
					Set<String> tollBridgeList = new HashSet<>();

					for (List<Double> geoCoord : geoCoords) {
						String wkt = String.format(Locale.US, "POINT(%f %f)", geoCoord.get(0), geoCoord.get(1));
						List<Object[]> results = tollBridgesRepository.findNearbyBridges(wkt, 1000.0);
						for (Object[] row : results) {
							String name = (String) row[0];
							Double price = (Double) row[1];
							tollBridgeList.add(name + " ücreti: " + price + "₺");
						}
					}

					// DTO oluştur RouteResponseDTO
					return new DirectionsResponseDTO(distance, duration, allTollFees, tollBridgeList, instructions,
							geoCoords);
				});
	}
	
    public Double calculateRoadIntersectionLength(List<List<Double>> geoCoords) {
        // Koordinat listesini WKT'ye çevir
        String wkt = convertToWKT(geoCoords);
        
        // RoadsRepository üzerinden sorgu çek ve kesişim uzunluğunu al
        return roadsRepository.getApproxIntersectLengthMeters(wkt);
    }

	
    private String convertToWKT(List<List<Double>> coordinates) {
        if (coordinates == null || coordinates.isEmpty()) {
            throw new IllegalArgumentException("Koordinat listesi boş olamaz");
        }

        StringBuilder sb = new StringBuilder("LINESTRING(");
        for (int i = 0; i < coordinates.size(); i++) {
            List<Double> point = coordinates.get(i);
            if (point.size() != 2) {
                throw new IllegalArgumentException("Her koordinat [lon, lat] formatında olmalıdır.");
            }
            sb.append(point.get(0)).append(" ").append(point.get(1));
            if (i < coordinates.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
				
}