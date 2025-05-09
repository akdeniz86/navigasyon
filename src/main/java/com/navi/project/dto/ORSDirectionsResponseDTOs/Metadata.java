package com.navi.project.dto.ORSDirectionsResponseDTOs;

public class Metadata {
    private String attribution;
    private String service;
    private long timestamp;
    private Query query;
    private Engine engine;

    public String getAttribution() { return attribution; }
    public void setAttribution(String value) { this.attribution = value; }

    public String getService() { return service; }
    public void setService(String value) { this.service = value; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long value) { this.timestamp = value; }

    public Query getQuery() { return query; }
    public void setQuery(Query value) { this.query = value; }

    public Engine getEngine() { return engine; }
    public void setEngine(Engine value) { this.engine = value; }
}
