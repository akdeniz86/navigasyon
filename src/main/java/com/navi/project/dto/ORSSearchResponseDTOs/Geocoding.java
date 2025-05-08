package com.navi.project.dto.ORSSearchResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Geocoding {
    private String version;
    private String attribution;
    private Query query;
    private List<String> warnings;
    private Engine engine;
    private long timestamp;

    @JsonProperty("version")
    public String getVersion() { return version; }
    @JsonProperty("version")
    public void setVersion(String value) { this.version = value; }

    @JsonProperty("attribution")
    public String getAttribution() { return attribution; }
    @JsonProperty("attribution")
    public void setAttribution(String value) { this.attribution = value; }

    @JsonProperty("query")
    public Query getQuery() { return query; }
    @JsonProperty("query")
    public void setQuery(Query value) { this.query = value; }

    @JsonProperty("warnings")
    public List<String> getWarnings() { return warnings; }
    @JsonProperty("warnings")
    public void setWarnings(List<String> value) { this.warnings = value; }

    @JsonProperty("engine")
    public Engine getEngine() { return engine; }
    @JsonProperty("engine")
    public void setEngine(Engine value) { this.engine = value; }

    @JsonProperty("timestamp")
    public long getTimestamp() { return timestamp; }
    @JsonProperty("timestamp")
    public void setTimestamp(long value) { this.timestamp = value; }
}
