package com.navi.project.dto.ORSGeocodeSearchResponseDTOs;

import java.util.List;

public class Geometry {
	private String type;
	private List<Double> coordinates;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Double> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}
	public Geometry(String type, List<Double> coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}

	



}
