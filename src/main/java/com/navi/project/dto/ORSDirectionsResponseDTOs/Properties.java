package com.navi.project.dto.ORSDirectionsResponseDTOs;

import java.util.List;

public class Properties {
    private List<Segment> segments;
    private Extras extras;
    private List<Long> wayPoints;
    private PropertiesSummary summary;

    public List<Segment> getSegments() { return segments; }
    public void setSegments(List<Segment> value) { this.segments = value; }

    public Extras getExtras() { return extras; }
    public void setExtras(Extras value) { this.extras = value; }

    public List<Long> getWayPoints() { return wayPoints; }
    public void setWayPoints(List<Long> value) { this.wayPoints = value; }

    public PropertiesSummary getSummary() { return summary; }
    public void setSummary(PropertiesSummary value) { this.summary = value; }
}
