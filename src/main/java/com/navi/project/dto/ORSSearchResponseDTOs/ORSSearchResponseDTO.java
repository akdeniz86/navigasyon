package com.navi.project.dto.ORSSearchResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class ORSSearchResponseDTO {
    private Geocoding geocoding;
    private String type;
    private List<Feature> features;
    private List<Double> bbox;

    @JsonProperty("geocoding")
    public Geocoding getGeocoding() { return geocoding; }
    @JsonProperty("geocoding")
    public void setGeocoding(Geocoding value) { this.geocoding = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("features")
    public List<Feature> getFeatures() { return features; }
    @JsonProperty("features")
    public void setFeatures(List<Feature> value) { this.features = value; }

    @JsonProperty("bbox")
    public List<Double> getBbox() { return bbox; }
    @JsonProperty("bbox")
    public void setBbox(List<Double> value) { this.bbox = value; }
}
