package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;

public class RouteSummary {
    private double distance;
    private double duration;

    @JsonProperty("distance")
    public double getDistance() { return distance; }
    @JsonProperty("distance")
    public void setDistance(double value) { this.distance = value; }

    @JsonProperty("duration")
    public double getDuration() { return duration; }
    @JsonProperty("duration")
    public void setDuration(double value) { this.duration = value; }
}
