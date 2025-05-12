package com.navi.project.dto.ORSDirectionsResponseDTOs;

import java.util.List;

public class Segment {
    private Double distance;
    private Double duration;
    private List<Step> steps;

    public Double getDistance() { return distance; }
    public void setDistance(Double value) { this.distance = value; }

    public Double getDuration() { return duration; }
    public void setDuration(Double value) { this.duration = value; }

    public List<Step> getSteps() { return steps; }
    public void setSteps(List<Step> value) { this.steps = value; }
}
