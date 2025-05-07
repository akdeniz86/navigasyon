package com.navi.project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.navi.project.dto.GeocodeResultDTO;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
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



	public Mono<List<GeocodeResultDTO>> searchAddress(String text) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder                        
                        .queryParam("api_key", apiKey)
                        .queryParam("text", text)
                        .queryParam("boundary.country", "TR")
                        .queryParam("size", 3)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .map(json -> {
                    @SuppressWarnings("unchecked")
					List<Map<String, Object>> features = (List<Map<String, Object>>) json.get("features");
                    
                    return features.stream().map(feature -> {
                        @SuppressWarnings("unchecked")
						Map<String, Object> properties = (Map<String, Object>) feature.get("properties");
                        @SuppressWarnings("unchecked")
						Map<String, Object> geometry = (Map<String, Object>) feature.get("geometry");
                        @SuppressWarnings("unchecked")
						List<Double> coordinates = (List<Double>) geometry.get("coordinates");

                        return new GeocodeResultDTO(
                                (String) properties.get("label"),
                                coordinates.get(0),
                                coordinates.get(1)
                        );
                    }).collect(Collectors.toList());
                });
    }
}