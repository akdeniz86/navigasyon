package com.navi.project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.navi.project.dto.GeocodeSearchResponseDTOs.GeocodeSearchResponseDTO;
import com.navi.project.dto.ORSGeocodeSearchResponseDTOs.ORSGeocodeSearchResponseDTO;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeocodeSearchService {

    private final WebClient webClient;

    @Value("${ors.api.key}")
    private String apiKey;

    @Value("${ors.geocodesearch.uri}")
    private String geocodeSearchUri;    

    public GeocodeSearchService(WebClient.Builder webClientBuilder, @Value("${ors.geocodesearch.uri}") String geocodeSearchUri) {
        this.webClient = webClientBuilder.baseUrl(geocodeSearchUri).build();
    }
    //verilen texte göre coordinat list döner
    public Mono<List<GeocodeSearchResponseDTO>> searchAddress(String text) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("api_key", apiKey)
                        .queryParam("text", text)
                        .queryParam("boundary.country", "TR")
                        .queryParam("size", 3)
                        .build())
                .retrieve()
                .bodyToMono(ORSGeocodeSearchResponseDTO.class)
                .map(response ->
                    response.getFeatures().stream()
                            .map(feature -> {
                                String label = feature.getProperties().getLabel();
                                List<Double> coordinates = feature.getGeometry().getCoordinates();
                                return new GeocodeSearchResponseDTO(label, coordinates.get(0), coordinates.get(1));
                            })
                            .collect(Collectors.toList())
                );
    }  
    
}