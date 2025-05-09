package com.navi.project.dto.GeocodeSearchResponseDTOs;

public class GeocodeSearchResponseDTO {
    private String label;
    private double lon;
    private double lat;

    public String getLabel() { return label; }
    public void setLabel(String value) { this.label = value; }

    public double getLon() { return lon; }
    public void setLon(double value) { this.lon = value; }

    public double getLat() { return lat; }
    public void setLat(double value) { this.lat = value; }
    
	public GeocodeSearchResponseDTO(String label, double lon, double lat) {
		super();
		this.label = label;
		this.lon = lon;
		this.lat = lat;
	}
    
    
}
