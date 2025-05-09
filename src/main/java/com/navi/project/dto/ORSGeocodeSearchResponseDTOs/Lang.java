package com.navi.project.dto.ORSGeocodeSearchResponseDTOs;

public class Lang {
    private String name;
    private String iso6391;
    private String iso6393;
    private String via;
    private boolean defaulted;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getIso6391() { return iso6391; }
    public void setIso6391(String value) { this.iso6391 = value; }

    public String getIso6393() { return iso6393; }
    public void setIso6393(String value) { this.iso6393 = value; }

    public String getVia() { return via; }
    public void setVia(String value) { this.via = value; }

    public boolean getDefaulted() { return defaulted; }
    public void setDefaulted(boolean value) { this.defaulted = value; }
}
