package com.navi.project.dto.ORSDirectionsResponseDTOs;

import java.util.List;

public class Segment {
    private double distance;
    private double duration;
    private List<Step> steps;

    public double getDistance() { return distance; }
    public void setDistance(double value) { this.distance = value; }

    public double getDuration() { return duration; }
    public void setDuration(double value) { this.duration = value; }

    public List<Step> getSteps() { return steps; }
    public void setSteps(List<Step> value) { this.steps = value; }
}
