package com.navi.project.dto.ORSGeocodeSearchResponseDTOs;

import java.util.List;

public class ORSGeocodeSearchResponseDTO {
    private Geocoding geocoding;
    private String type;
    private List<Feature> features;
    private List<Double> bbox;

    public Geocoding getGeocoding() { return geocoding; }
    public void setGeocoding(Geocoding value) { this.geocoding = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public List<Feature> getFeatures() { return features; }
    public void setFeatures(List<Feature> value) { this.features = value; }

    public List<Double> getBbox() { return bbox; }
    public void setBbox(List<Double> value) { this.bbox = value; }
}
