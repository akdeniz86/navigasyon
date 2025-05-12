package com.navi.project.dto.ORSDirectionsResponseDTOs;

import java.util.List;

public class ORSDirectionsResponseDTO {
    private String type;
    private List<Double> bbox;
    private List<Feature> features;
    private Metadata metadata;

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public List<Double> getBbox() { return bbox; }
    public void setBbox(List<Double> value) { this.bbox = value; }

    public List<Feature> getFeatures() { return features; }
    public void setFeatures(List<Feature> value) { this.features = value; }

    public Metadata getMetadata() { return metadata; }
    public void setMetadata(Metadata value) { this.metadata = value; }
}
