package com.navi.project.dto.ORSDirectionsResponseDTOs;

import java.util.List;

public class Geometry {
    private List<List<Double>> coordinates;
    private String type;

    public List<List<Double>> getCoordinates() { return coordinates; }
    public void setCoordinates(List<List<Double>> value) { this.coordinates = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }
}
