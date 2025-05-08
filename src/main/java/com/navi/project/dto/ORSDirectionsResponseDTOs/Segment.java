package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Segment {
    private double distance;
    private double duration;
    private List<Step> steps;

    @JsonProperty("distance")
    public double getDistance() { return distance; }
    @JsonProperty("distance")
    public void setDistance(double value) { this.distance = value; }

    @JsonProperty("duration")
    public double getDuration() { return duration; }
    @JsonProperty("duration")
    public void setDuration(double value) { this.duration = value; }

    @JsonProperty("steps")
    public List<Step> getSteps() { return steps; }
    @JsonProperty("steps")
    public void setSteps(List<Step> value) { this.steps = value; }
}
