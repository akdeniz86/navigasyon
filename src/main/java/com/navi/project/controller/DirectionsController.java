package com.navi.project.controller;

import org.springframework.web.bind.annotation.*;

import com.navi.project.dto.DirectionsRequestDTO;
import com.navi.project.dto.DirectionsResponseDTO;
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
    public Mono<DirectionsResponseDTO> calculateRoute(@RequestBody DirectionsRequestDTO requestDTO) {
        return directionsService.calculateRoute(requestDTO);
    }
}