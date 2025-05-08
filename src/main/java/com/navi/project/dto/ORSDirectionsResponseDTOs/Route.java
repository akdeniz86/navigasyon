package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Route {
    private RouteSummary summary;
    private List<Segment> segments;
    private List<Double> bbox;
    private String geometry;
    private List<Long> wayPoints;
    private Extras extras;

    @JsonProperty("summary")
    public RouteSummary getSummary() { return summary; }
    @JsonProperty("summary")
    public void setSummary(RouteSummary value) { this.summary = value; }

    @JsonProperty("segments")
    public List<Segment> getSegments() { return segments; }
    @JsonProperty("segments")
    public void setSegments(List<Segment> value) { this.segments = value; }

    @JsonProperty("bbox")
    public List<Double> getBbox() { return bbox; }
    @JsonProperty("bbox")
    public void setBbox(List<Double> value) { this.bbox = value; }

    @JsonProperty("geometry")
    public String getGeometry() { return geometry; }
    @JsonProperty("geometry")
    public void setGeometry(String value) { this.geometry = value; }

    @JsonProperty("way_points")
    public List<Long> getWayPoints() { return wayPoints; }
    @JsonProperty("way_points")
    public void setWayPoints(List<Long> value) { this.wayPoints = value; }

    @JsonProperty("extras")
    public Extras getExtras() { return extras; }
    @JsonProperty("extras")
    public void setExtras(Extras value) { this.extras = value; }
}
