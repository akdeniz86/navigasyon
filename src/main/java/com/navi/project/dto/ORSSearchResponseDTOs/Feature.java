package com.navi.project.dto.ORSSearchResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Feature {
    private String type;
    private Geometry geometry;
    private Properties properties;
    private List<Double> bbox;

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("geometry")
    public Geometry getGeometry() { return geometry; }
    @JsonProperty("geometry")
    public void setGeometry(Geometry value) { this.geometry = value; }

    @JsonProperty("properties")
    public Properties getProperties() { return properties; }
    @JsonProperty("properties")
    public void setProperties(Properties value) { this.properties = value; }

    @JsonProperty("bbox")
    public List<Double> getBbox() { return bbox; }
    @JsonProperty("bbox")
    public void setBbox(List<Double> value) { this.bbox = value; }
}
