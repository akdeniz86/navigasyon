package com.navi.project.dto.ORSDirectionsResponseDTOs;

import java.util.List;

public class ORSDirectionsResponseDTO {
    private List<Double> bbox;
    private List<Route> routes;
    private Metadata metadata;

    public List<Double> getBbox() { return bbox; }
    public void setBbox(List<Double> value) { this.bbox = value; }

    public List<Route> getRoutes() { return routes; }
    public void setRoutes(List<Route> value) { this.routes = value; }

    public Metadata getMetadata() { return metadata; }
    public void setMetadata(Metadata value) { this.metadata = value; }
	public ORSDirectionsResponseDTO(List<Double> bbox, List<Route> routes, Metadata metadata) {
		super();
		this.bbox = bbox;
		this.routes = routes;
		this.metadata = metadata;
	}
    
    
}
