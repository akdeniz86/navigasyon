package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Step {
    private double distance;
    private double duration;
    private long type;
    private String instruction;
    private String name;
    private List<Long> wayPoints;
    private Long exitNumber;

    @JsonProperty("distance")
    public double getDistance() { return distance; }
    @JsonProperty("distance")
    public void setDistance(double value) { this.distance = value; }

    @JsonProperty("duration")
    public double getDuration() { return duration; }
    @JsonProperty("duration")
    public void setDuration(double value) { this.duration = value; }

    @JsonProperty("type")
    public long getType() { return type; }
    @JsonProperty("type")
    public void setType(long value) { this.type = value; }

    @JsonProperty("instruction")
    public String getInstruction() { return instruction; }
    @JsonProperty("instruction")
    public void setInstruction(String value) { this.instruction = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("way_points")
    public List<Long> getWayPoints() { return wayPoints; }
    @JsonProperty("way_points")
    public void setWayPoints(List<Long> value) { this.wayPoints = value; }

    @JsonProperty("exit_number")
    public Long getExitNumber() { return exitNumber; }
    @JsonProperty("exit_number")
    public void setExitNumber(Long value) { this.exitNumber = value; }
}
