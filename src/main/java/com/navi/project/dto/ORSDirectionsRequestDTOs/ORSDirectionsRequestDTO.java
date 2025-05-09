package com.navi.project.dto.ORSDirectionsRequestDTOs;

import java.util.List;

public class ORSDirectionsRequestDTO {
    private List<List<Double>> coordinates;
    private List<String> extra_info;
    private String language;
    private Options options;
    private String preference;
    private String units;

    public List<List<Double>> getCoordinates() { return coordinates; }
    public void setCoordinates(List<List<Double>> value) { this.coordinates = value; }

    public String getLanguage() { return language; }
    public void setLanguage(String value) { this.language = value; }

    public Options getOptions() { return options; }
    public void setOptions(Options value) { this.options = value; }

    public String getPreference() { return preference; }
    public void setPreference(String value) { this.preference = value; }

    public String getUnits() { return units; }
    public void setUnits(String value) { this.units = value; }
	public List<String> getExtra_info() {
		return extra_info;
	}
	public void setExtra_info(List<String> extra_info) {
		this.extra_info = extra_info;
	}
}
