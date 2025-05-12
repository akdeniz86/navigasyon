package com.navi.project.dto.ORSDirectionsResponseDTOs;

public class SummaryElement {
    private long value;
    private Double distance;
    private Double amount;

    public long getValue() { return value; }
    public void setValue(long value) { this.value = value; }

    public Double getDistance() { return distance; }
    public void setDistance(Double value) { this.distance = value; }

    public Double getAmount() { return amount; }
    public void setAmount(Double value) { this.amount = value; }
}
