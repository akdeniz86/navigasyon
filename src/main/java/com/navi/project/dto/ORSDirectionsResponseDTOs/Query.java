package com.navi.project.dto.ORSDirectionsResponseDTOs;

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

    public List<List<Double>> getCoordinates() { return coordinates; }
    public void setCoordinates(List<List<Double>> value) { this.coordinates = value; }

    public String getProfile() { return profile; }
    public void setProfile(String value) { this.profile = value; }

    public String getProfileName() { return profileName; }
    public void setProfileName(String value) { this.profileName = value; }

    public String getPreference() { return preference; }
    public void setPreference(String value) { this.preference = value; }

    public String getFormat() { return format; }
    public void setFormat(String value) { this.format = value; }

    public String getUnits() { return units; }
    public void setUnits(String value) { this.units = value; }

    public String getLanguage() { return language; }
    public void setLanguage(String value) { this.language = value; }

    public List<String> getExtraInfo() { return extraInfo; }
    public void setExtraInfo(List<String> value) { this.extraInfo = value; }

    public Options getOptions() { return options; }
    public void setOptions(Options value) { this.options = value; }
}
