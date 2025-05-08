package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class ORSDirectionsResponseDTO {
    private List<Double> bbox;
    private List<Route> routes;
    private Metadata metadata;

    @JsonProperty("bbox")
    public List<Double> getBbox() { return bbox; }
    @JsonProperty("bbox")
    public void setBbox(List<Double> value) { this.bbox = value; }

    @JsonProperty("routes")
    public List<Route> getRoutes() { return routes; }
    @JsonProperty("routes")
    public void setRoutes(List<Route> value) { this.routes = value; }

    @JsonProperty("metadata")
    public Metadata getMetadata() { return metadata; }
    @JsonProperty("metadata")
    public void setMetadata(Metadata value) { this.metadata = value; }
}
