package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Query {
    private List<List<Double>> coordinates;
    private String profile;
    private String profileName;
    private String preference;
    private String format;
    private String units;
    private String language;
    private List<String> extraInfo;
    private Options options;

    @JsonProperty("coordinates")
    public List<List<Double>> getCoordinates() { return coordinates; }
    @JsonProperty("coordinates")
    public void setCoordinates(List<List<Double>> value) { this.coordinates = value; }

    @JsonProperty("profile")
    public String getProfile() { return profile; }
    @JsonProperty("profile")
    public void setProfile(String value) { this.profile = value; }

    @JsonProperty("profileName")
    public String getProfileName() { return profileName; }
    @JsonProperty("profileName")
    public void setProfileName(String value) { this.profileName = value; }

    @JsonProperty("preference")
    public String getPreference() { return preference; }
    @JsonProperty("preference")
    public void setPreference(String value) { this.preference = value; }

    @JsonProperty("format")
    public String getFormat() { return format; }
    @JsonProperty("format")
    public void setFormat(String value) { this.format = value; }

    @JsonProperty("units")
    public String getUnits() { return units; }
    @JsonProperty("units")
    public void setUnits(String value) { this.units = value; }

    @JsonProperty("language")
    public String getLanguage() { return language; }
    @JsonProperty("language")
    public void setLanguage(String value) { this.language = value; }

    @JsonProperty("extra_info")
    public List<String> getExtraInfo() { return extraInfo; }
    @JsonProperty("extra_info")
    public void setExtraInfo(List<String> value) { this.extraInfo = value; }

    @JsonProperty("options")
    public Options getOptions() { return options; }
    @JsonProperty("options")
    public void setOptions(Options value) { this.options = value; }
}
