package com.navi.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.navi.project.dto.GeocodeSearchResponseDTOs.GeocodeSearchResponseDTO;
import com.navi.project.service.GeocodeSearchService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/geocode")
@CrossOrigin(origins = "*") // Angular'dan erişim için CORS izni
public class GeocodeSearchController {

    private final GeocodeSearchService geocodeSearchService;
    
    public GeocodeSearchController(GeocodeSearchService geocodeSearchService) {
		this.geocodeSearchService = geocodeSearchService;
    }

	@GetMapping("/search")	
    public Mono<List<GeocodeSearchResponseDTO>>  search(@RequestParam String text) {
        return geocodeSearchService.searchAddress(text);
    }
}
