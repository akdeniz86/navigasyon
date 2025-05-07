package com.navi.project.dto;

public class GeocodeResultDTO {
    private String label;
    private Double lon;
    private Double lat;

    public GeocodeResultDTO() {
    }

    public GeocodeResultDTO(String label, Double lon, Double lat) {
        this.label = label;
        this.lon = lon;
        this.lat = lat;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
