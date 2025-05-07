package com.navi.project.dto;

import java.util.List;

public class DirectionsResponseDTO {
    private Double distance;
    private Double duration;
    private List<String> instructions;
    private String allTollFees;
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
	public List<List<Double>> getGeoCoord() {
		return geoCoord;
	}
	public void setGeoCoord(List<List<Double>> geoCoord) {
		this.geoCoord = geoCoord;
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
	public DirectionsResponseDTO(Double distance, Double duration, String allTollFees, List<String> instructions,
			List<List<Double>> geoCoord) {
		super();
		this.distance = distance;
		this.duration = duration;
		this.instructions = instructions;
		this.allTollFees = allTollFees;
		this.geoCoord = geoCoord;
	}



    
 
	
	
}
