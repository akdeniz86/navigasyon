package com.navi.project.dto;

import java.util.List;
import java.util.Set;

public class DirectionsResponseDTO {
    private Double distance;
    private Double duration;
    private String allTollFees;
    private Set<String> tollBridgeList;
    private List<String> instructions;    
    private List<List<Double>> geoCoord;
    
    
    // constructor, getter/setter
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public List<String> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}
	public String getAllTollFees() {
		return allTollFees;
	}
	public void setAllTollFees(String allTollFees) {
		this.allTollFees = allTollFees;
	}
	public List<List<Double>> getGeoCoord() {
		return geoCoord;
	}
	public void setGeoCoord(List<List<Double>> geoCoord) {
		this.geoCoord = geoCoord;
	}
	public Set<String> getTollBridgeList() {
		return tollBridgeList;
	}
	public void setTollBridgeList(Set<String> tollBridgeList) {
		this.tollBridgeList = tollBridgeList;
	}
	public DirectionsResponseDTO(Double distance, Double duration, String allTollFees, Set<String> tollBridgeList, List<String> instructions,
			List<List<Double>> geoCoord) {
		super();
		this.distance = distance;
		this.duration = duration;
		this.instructions = instructions;
		this.allTollFees = allTollFees;
		this.geoCoord = geoCoord;
		this.tollBridgeList = tollBridgeList;
	}
    
	
    
  
	
}
