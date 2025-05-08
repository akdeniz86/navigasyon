package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;

public class SummaryElement {
    private long value;
    private double distance;
    private double amount;

    @JsonProperty("value")
    public long getValue() { return value; }
    @JsonProperty("value")
    public void setValue(long value) { this.value = value; }

    @JsonProperty("distance")
    public double getDistance() { return distance; }
    @JsonProperty("distance")
    public void setDistance(double value) { this.distance = value; }

    @JsonProperty("amount")
    public double getAmount() { return amount; }
    @JsonProperty("amount")
    public void setAmount(double value) { this.amount = value; }
}
