package com.navi.project.dto;

public class CoordinateDTO {
    private Double lon; // boylam
    private Double lat; //enlem

    public CoordinateDTO() {
    }

    public CoordinateDTO(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
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
