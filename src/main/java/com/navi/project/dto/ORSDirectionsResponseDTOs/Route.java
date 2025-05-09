package com.navi.project.dto.ORSDirectionsResponseDTOs;

import java.util.List;

public class Route {
    private RouteSummary summary;
    private List<Segment> segments;
    private List<Double> bbox;
    private String geometry;
    private List<Long> wayPoints;
    private Extras extras;

    public RouteSummary getSummary() { return summary; }
    public void setSummary(RouteSummary value) { this.summary = value; }

    public List<Segment> getSegments() { return segments; }
    public void setSegments(List<Segment> value) { this.segments = value; }

    public List<Double> getBbox() { return bbox; }
    public void setBbox(List<Double> value) { this.bbox = value; }

    public String getGeometry() { return geometry; }
    public void setGeometry(String value) { this.geometry = value; }

    public List<Long> getWayPoints() { return wayPoints; }
    public void setWayPoints(List<Long> value) { this.wayPoints = value; }

    public Extras getExtras() { return extras; }
    public void setExtras(Extras value) { this.extras = value; }
}
