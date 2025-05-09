package com.navi.project.dto.DirectionsResponseDTOs;

import java.util.List;
import java.util.Set;

public class DirectionsResponseDTO {
    private double distance;
    private double duration;
    private String allTollFees;
    private Set<String> tollBridgeList;
    private List<String> instructions;
    private List<List<Double>> geoCoord;

    public double getDistance() { return distance; }
    public void setDistance(double value) { this.distance = value; }

    public double getDuration() { return duration; }
    public void setDuration(double value) { this.duration = value; }

    public String getAllTollFees() { return allTollFees; }
    public void setAllTollFees(String value) { this.allTollFees = value; }
    
	public Set<String> getTollBridgeList() {return tollBridgeList;}
	public void setTollBridgeList(Set<String> tollBridgeList) {this.tollBridgeList = tollBridgeList;}

    public List<String> getInstructions() { return instructions; }
    public void setInstructions(List<String> value) { this.instructions = value; }

    public List<List<Double>> getGeoCoord() { return geoCoord; }
    public void setGeoCoord(List<List<Double>> value) { this.geoCoord = value; }
    
	public DirectionsResponseDTO(double distance, double duration, String allTollFees, Set<String> tollBridgeList,
			List<String> instructions, List<List<Double>> geoCoord) {
		super();
		this.distance = distance;
		this.duration = duration;
		this.allTollFees = allTollFees;
		this.tollBridgeList = tollBridgeList;
		this.instructions = instructions;
		this.geoCoord = geoCoord;
	}    
    
}