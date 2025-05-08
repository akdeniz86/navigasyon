package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;

public class Metadata {
    private String attribution;
    private String service;
    private long timestamp;
    private Query query;
    private Engine engine;

    @JsonProperty("attribution")
    public String getAttribution() { return attribution; }
    @JsonProperty("attribution")
    public void setAttribution(String value) { this.attribution = value; }

    @JsonProperty("service")
    public String getService() { return service; }
    @JsonProperty("service")
    public void setService(String value) { this.service = value; }

    @JsonProperty("timestamp")
    public long getTimestamp() { return timestamp; }
    @JsonProperty("timestamp")
    public void setTimestamp(long value) { this.timestamp = value; }

    @JsonProperty("query")
    public Query getQuery() { return query; }
    @JsonProperty("query")
    public void setQuery(Query value) { this.query = value; }

    @JsonProperty("engine")
    public Engine getEngine() { return engine; }
    @JsonProperty("engine")
    public void setEngine(Engine value) { this.engine = value; }
}
