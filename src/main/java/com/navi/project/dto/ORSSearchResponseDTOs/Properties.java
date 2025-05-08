package com.navi.project.dto.ORSSearchResponseDTOs;

import com.fasterxml.jackson.annotation.*;

public class Properties {
    private String id;
    private String gid;
    private String layer;
    private String source;
    private String sourceID;
    private String name;
    private double confidence;
    private String matchType;
    private String accuracy;
    private String country;
    private String countryGid;
    private String countryA;
    private String region;
    private String regionGid;
    private String regionA;
    private String county;
    private String countyGid;
    private String countyA;
    private String locality;
    private String localityGid;
    private String continent;
    private String continentGid;
    private String label;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("gid")
    public String getGid() { return gid; }
    @JsonProperty("gid")
    public void setGid(String value) { this.gid = value; }

    @JsonProperty("layer")
    public String getLayer() { return layer; }
    @JsonProperty("layer")
    public void setLayer(String value) { this.layer = value; }

    @JsonProperty("source")
    public String getSource() { return source; }
    @JsonProperty("source")
    public void setSource(String value) { this.source = value; }

    @JsonProperty("source_id")
    public String getSourceID() { return sourceID; }
    @JsonProperty("source_id")
    public void setSourceID(String value) { this.sourceID = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("confidence")
    public double getConfidence() { return confidence; }
    @JsonProperty("confidence")
    public void setConfidence(double value) { this.confidence = value; }

    @JsonProperty("match_type")
    public String getMatchType() { return matchType; }
    @JsonProperty("match_type")
    public void setMatchType(String value) { this.matchType = value; }

    @JsonProperty("accuracy")
    public String getAccuracy() { return accuracy; }
    @JsonProperty("accuracy")
    public void setAccuracy(String value) { this.accuracy = value; }

    @JsonProperty("country")
    public String getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(String value) { this.country = value; }

    @JsonProperty("country_gid")
    public String getCountryGid() { return countryGid; }
    @JsonProperty("country_gid")
    public void setCountryGid(String value) { this.countryGid = value; }

    @JsonProperty("country_a")
    public String getCountryA() { return countryA; }
    @JsonProperty("country_a")
    public void setCountryA(String value) { this.countryA = value; }

    @JsonProperty("region")
    public String getRegion() { return region; }
    @JsonProperty("region")
    public void setRegion(String value) { this.region = value; }

    @JsonProperty("region_gid")
    public String getRegionGid() { return regionGid; }
    @JsonProperty("region_gid")
    public void setRegionGid(String value) { this.regionGid = value; }

    @JsonProperty("region_a")
    public String getRegionA() { return regionA; }
    @JsonProperty("region_a")
    public void setRegionA(String value) { this.regionA = value; }

    @JsonProperty("county")
    public String getCounty() { return county; }
    @JsonProperty("county")
    public void setCounty(String value) { this.county = value; }

    @JsonProperty("county_gid")
    public String getCountyGid() { return countyGid; }
    @JsonProperty("county_gid")
    public void setCountyGid(String value) { this.countyGid = value; }

    @JsonProperty("county_a")
    public String getCountyA() { return countyA; }
    @JsonProperty("county_a")
    public void setCountyA(String value) { this.countyA = value; }

    @JsonProperty("locality")
    public String getLocality() { return locality; }
    @JsonProperty("locality")
    public void setLocality(String value) { this.locality = value; }

    @JsonProperty("locality_gid")
    public String getLocalityGid() { return localityGid; }
    @JsonProperty("locality_gid")
    public void setLocalityGid(String value) { this.localityGid = value; }

    @JsonProperty("continent")
    public String getContinent() { return continent; }
    @JsonProperty("continent")
    public void setContinent(String value) { this.continent = value; }

    @JsonProperty("continent_gid")
    public String getContinentGid() { return continentGid; }
    @JsonProperty("continent_gid")
    public void setContinentGid(String value) { this.continentGid = value; }

    @JsonProperty("label")
    public String getLabel() { return label; }
    @JsonProperty("label")
    public void setLabel(String value) { this.label = value; }
}
