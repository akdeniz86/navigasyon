package com.navi.project.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.navi.project.dto.TollWayDto;
import com.navi.project.dto.DirectionsResponseDTOs.DirectionsResponseDTO;
import com.navi.project.dto.ORSDirectionsRequestDTOs.ORSDirectionsRequestDTO;
import com.navi.project.dto.ORSDirectionsResponseDTOs.Feature;
import com.navi.project.dto.ORSDirectionsResponseDTOs.ORSDirectionsResponseDTO;

import com.navi.project.dto.ORSDirectionsResponseDTOs.Segment;
import com.navi.project.dto.ORSDirectionsResponseDTOs.Step;
import com.navi.project.repo.TollBridgesRepository;
import com.navi.project.repo.TollWayRepository;

import reactor.core.publisher.Mono;

@Service
public class DirectionsService {

	private final WebClient webClient;

	private final TollBridgesRepository tollBridgesRepository;
	private final TollWayRepository tollWayRepository;

	@Value("${ors.api.key}")
	private String apiKey;

	@Value("${ors.directions.uri}")
	private String directionsUri;

	public DirectionsService(WebClient.Builder webClientBuilder, TollBridgesRepository tollBridgesRepository,
			TollWayRepository tollWayRepository) {
		this.webClient = webClientBuilder
				.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(512 * 1024)) // 512KB tampon boyutu artırıldı
				.build();
		this.tollBridgesRepository = tollBridgesRepository;
		this.tollWayRepository = tollWayRepository;
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

					// yol tarifi Talimatlarını listeleme
					List<String> instructions = steps.stream().map(step -> {
						String instruction = step.getInstruction();
						Double distance = step.getDistance();
						Double duration = step.getDuration();
						return instruction + " ( " + distance + " km, " + duration + " sn )" + step.getName();
					}).collect(Collectors.toList());

					// Mesafe ve süre hesaplama
					double distance = segments.get(0).getDistance();
					double duration = segments.get(0).getDuration();

					List<List<Double>> geoCoord = feature.getGeometry().getCoordinates();

					// koordinat dizisinin köprüden geçiyormu sorgusu
					// 1. Köprü ve GateA sorguları
					Set<String> tollBridgeSet = new HashSet<>();
					List<String> tollBridgeList = new ArrayList<>();
					List<TollWayDto> gateAList = new ArrayList<>();
					List<TollWayDto> gateBList = new ArrayList<>();
					double totalBridgeFee = 0.0;


					String lineStringWkt = "LINESTRING(" + geoCoord.stream()
							.map(coord -> String.format(Locale.US, "%f %f", coord.get(0), coord.get(1)))
							.collect(Collectors.joining(", ")) + ")";

					List<Object[]> bridgeResults = tollBridgesRepository.findNearbyBridges(lineStringWkt, 50);

					for (Object[] row : bridgeResults) {
						String name = (String) row[0];
						Double price = (Double) row[1];
						String entry = "  " + name + " ücreti : " + price + "₺";

						if (tollBridgeSet.add(entry)) {
							tollBridgeList.add(entry);
							totalBridgeFee += price;
						}
					}

					gateAList = tollWayRepository.findByGateAPoint(lineStringWkt, 50);
					gateBList = tollWayRepository.findByGateBPoint(lineStringWkt, 50);	
				

					// A ve B listelerini karşılaştır, aynı ID'ye sahip olanları yeni listeye ekle
					Set<Long> gateBIds = gateBList.stream().map(TollWayDto::getId).collect(Collectors.toSet());
					// id leri aynı olanlar liste yapılıyor
					List<TollWayDto> matchedTollWays = gateAList.stream().filter(a -> gateBIds.contains(a.getId()))
							.collect(Collectors.toList());

					List<String> allTollFees = new ArrayList<>();
					Double totalWaysFee = 0.0;
					// otoyol cevp listesi hazırlanıyor
					for (TollWayDto matchedTollWay : matchedTollWays) {
						String highwayName = matchedTollWay.getHighwayName();
						String highwayCode = matchedTollWay.getHighwayCode();
						String gateAName = matchedTollWay.getGateAName();
						String gateBName = matchedTollWay.getGateBName();
						Double fee = matchedTollWay.getFee();
						String entryPart = "  " + highwayName + " (" + highwayCode + ") (" + gateAName + "-" + gateBName
								+ ") ücreti : " + fee + "₺";

						// otoyol ücretlerinin tekrarlarını önlemek için
						if (!allTollFees.contains(entryPart)) {
							allTollFees.add(entryPart);
							totalWaysFee += fee; // ücretleri topla
						}

					}

					// otoyol ücretleri ve köprü ücreti toplamı
					Double totalFee = totalBridgeFee + totalWaysFee;

					System.out.println(totalFee);

					// DTO oluştur RouteResponseDTO mesafe , süre, toplamücret, otoyolname körpüler
					// adımlar koordinatlar
					return new DirectionsResponseDTO(distance, duration, totalFee, allTollFees, tollBridgeList,
							instructions, geoCoord);
				});
	}
}