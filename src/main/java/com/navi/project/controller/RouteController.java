package com.navi.project.controller;

import org.springframework.web.bind.annotation.*;

import com.navi.project.dto.RouteRequestDTO;
import com.navi.project.dto.RouteResponseDTO;
import com.navi.project.service.RouteService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/route")
@CrossOrigin(origins = "*") // Angular'dan erişim için
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/calculate")
    public Mono<RouteResponseDTO> calculateRoute(@RequestBody RouteRequestDTO requestDTO) {
        return routeService.calculateRoute(requestDTO);
    }
}