package com.navi.project.dto.DirectionsResponseDTOs;

import java.util.List;


public class DirectionsResponseDTO {
	private Double distance;
	private Double duration;
	private Double totalFee;
	List<String> allTollFees ;
	private List<String> tollBridgeList;
	private List<String>  instructions;
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
	public Double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	public List<String> getAllTollFees() {
		return allTollFees;
	}
	public void setAllTollFees(List<String> allTollFees) {
		this.allTollFees = allTollFees;
	}
	public List<String> getTollBridgeList() {
		return tollBridgeList;
	}
	public void setTollBridgeList(List<String> tollBridgeList) {
		this.tollBridgeList = tollBridgeList;
	}
	public List<String> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}
	public List<List<Double>> getGeoCoords() {
		return geoCoords;
	}
	public void setGeoCoords(List<List<Double>> geoCoords) {
		this.geoCoords = geoCoords;
	}
	public DirectionsResponseDTO(Double distance, Double duration, Double totalFee, List<String> allTollFees,
			List<String> tollBridgeList, List<String> instructions, List<List<Double>> geoCoords) {
		super();
		this.distance = distance;
		this.duration = duration;
		this.totalFee = totalFee;
		this.allTollFees = allTollFees;
		this.tollBridgeList = tollBridgeList;
		this.instructions = instructions;
		this.geoCoords = geoCoords;
	}
	
	
	
	
	
}
