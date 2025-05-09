package com.navi.project.dto.ORSDirectionsResponseDTOs;

public class SummaryElement {
    private long value;
    private double distance;
    private double amount;

    public long getValue() { return value; }
    public void setValue(long value) { this.value = value; }

    public double getDistance() { return distance; }
    public void setDistance(double value) { this.distance = value; }

    public double getAmount() { return amount; }
    public void setAmount(double value) { this.amount = value; }
}
