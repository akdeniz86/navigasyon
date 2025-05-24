package com.navi.project.controller;

import org.springframework.web.bind.annotation.*;

import com.navi.project.dto.DirectionsResponseDTOs.DirectionsResponseDTO;
import com.navi.project.dto.ORSDirectionsRequestDTOs.ORSDirectionsRequestDTO;
import com.navi.project.service.DirectionsService;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/route")
@CrossOrigin(origins = "*") // Angular'dan erişim için
public class DirectionsController {

    private final DirectionsService directionsService;

    public DirectionsController(DirectionsService directionsService) {
        this.directionsService = directionsService;
    }

    @PostMapping("/calculate")
    public Mono<DirectionsResponseDTO> calculateRoute(@RequestBody ORSDirectionsRequestDTO oRSDirectionsRequestDTO) {
        return directionsService.calculateRoute(oRSDirectionsRequestDTO);
    }
}
