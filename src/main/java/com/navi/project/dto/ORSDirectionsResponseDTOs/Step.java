package com.navi.project.dto.ORSDirectionsResponseDTOs;

import java.util.List;

public class Step {
    private Double distance;
    private Double duration;
    private long type;
    private String instruction;
    private String name;
    private List<Integer> way_points;
    private Long exitNumber;
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
	public long getType() {
		return type;
	}
	public void setType(long type) {
		this.type = type;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getWay_points() {
		return way_points;
	}
	public void setWay_points(List<Integer> way_points) {
		this.way_points = way_points;
	}
	public Long getExitNumber() {
		return exitNumber;
	}
	public void setExitNumber(Long exitNumber) {
		this.exitNumber = exitNumber;
	}
    
    
    

  

}
