package com.navi.project.dto.ORSDirectionsResponseDTOs;

import java.util.List;

public class Feature {
    private List<Double> bbox;
    private String type;
    private Properties properties;
    private Geometry geometry;

    public List<Double> getBbox() { return bbox; }
    public void setBbox(List<Double> value) { this.bbox = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public Properties getProperties() { return properties; }
    public void setProperties(Properties value) { this.properties = value; }

    public Geometry getGeometry() { return geometry; }
    public void setGeometry(Geometry value) { this.geometry = value; }
}
