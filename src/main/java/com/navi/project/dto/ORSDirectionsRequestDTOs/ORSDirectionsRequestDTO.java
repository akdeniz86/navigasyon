package com.navi.project.dto.ORSDirectionsRequestDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class ORSDirectionsRequestDTO {
    private List<List<Double>> coordinates;
    private List<String> extraInfo;
    private String language;
    private Options options;
    private String preference;
    private String units;

    @JsonProperty("coordinates")
    public List<List<Double>> getCoordinates() { return coordinates; }
    @JsonProperty("coordinates")
    public void setCoordinates(List<List<Double>> value) { this.coordinates = value; }

    @JsonProperty("extra_info")
    public List<String> getExtraInfo() { return extraInfo; }
    @JsonProperty("extra_info")
    public void setExtraInfo(List<String> value) { this.extraInfo = value; }

    @JsonProperty("language")
    public String getLanguage() { return language; }
    @JsonProperty("language")
    public void setLanguage(String value) { this.language = value; }

    @JsonProperty("options")
    public Options getOptions() { return options; }
    @JsonProperty("options")
    public void setOptions(Options value) { this.options = value; }

    @JsonProperty("preference")
    public String getPreference() { return preference; }
    @JsonProperty("preference")
    public void setPreference(String value) { this.preference = value; }

    @JsonProperty("units")
    public String getUnits() { return units; }
    @JsonProperty("units")
    public void setUnits(String value) { this.units = value; }
}
