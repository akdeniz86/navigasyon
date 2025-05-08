package com.navi.project.dto.ORSSearchResponseDTOs;

import com.fasterxml.jackson.annotation.*;

public class Lang {
    private String name;
    private String iso6391;
    private String iso6393;
    private String via;
    private boolean defaulted;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("iso6391")
    public String getIso6391() { return iso6391; }
    @JsonProperty("iso6391")
    public void setIso6391(String value) { this.iso6391 = value; }

    @JsonProperty("iso6393")
    public String getIso6393() { return iso6393; }
    @JsonProperty("iso6393")
    public void setIso6393(String value) { this.iso6393 = value; }

    @JsonProperty("via")
    public String getVia() { return via; }
    @JsonProperty("via")
    public void setVia(String value) { this.via = value; }

    @JsonProperty("defaulted")
    public boolean getDefaulted() { return defaulted; }
    @JsonProperty("defaulted")
    public void setDefaulted(boolean value) { this.defaulted = value; }
}
