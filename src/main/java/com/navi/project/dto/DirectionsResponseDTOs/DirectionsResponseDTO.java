package com.navi.project.dto.DirectionsResponseDTOs;

import java.util.List;
import java.util.Set;

public class DirectionsResponseDTO {
	private Double distance;
	private Double duration;
	private String allTollFees;
	private Set<String> tollBridgeList;
	private List<List<Double>> instructions;
	private List<List<Double>> geoCoords;
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
	public String getAllTollFees() {
		return allTollFees;
	}
	public void setAllTollFees(String allTollFees) {
		this.allTollFees = allTollFees;
	}
	public Set<String> getTollBridgeList() {
		return tollBridgeList;
	}
	public void setTollBridgeList(Set<String> tollBridgeList) {
		this.tollBridgeList = tollBridgeList;
	}
	public List<List<Double>> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<List<Double>> instructions) {
		this.instructions = instructions;
	}
	public List<List<Double>> getGeoCoords() {
		return geoCoords;
	}
	public void setGeoCoords(List<List<Double>> geoCoords) {
		this.geoCoords = geoCoords;
	}
	public DirectionsResponseDTO(Double distance, Double duration, String allTollFees, Set<String> tollBridgeList,
			List<List<Double>> instructions, List<List<Double>> geoCoords) {
		super();
		this.distance = distance;
		this.duration = duration;
		this.allTollFees = allTollFees;
		this.tollBridgeList = tollBridgeList;
		this.instructions = instructions;
		this.geoCoords = geoCoords;
	}
	
	
}
