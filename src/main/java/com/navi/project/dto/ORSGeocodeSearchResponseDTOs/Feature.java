package com.navi.project.dto.ORSGeocodeSearchResponseDTOs;

import java.util.List;

public class Feature {
    private String type;
    private Geometry geometry;
    private Properties properties;
    private List<Double> bbox;

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public Geometry getGeometry() { return geometry; }
    public void setGeometry(Geometry value) { this.geometry = value; }

    public Properties getProperties() { return properties; }
    public void setProperties(Properties value) { this.properties = value; }

    public List<Double> getBbox() { return bbox; }
    public void setBbox(List<Double> value) { this.bbox = value; }
}
