package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class Engine {
    private String version;
    private OffsetDateTime buildDate;
    private OffsetDateTime graphDate;

    @JsonProperty("version")
    public String getVersion() { return version; }
    @JsonProperty("version")
    public void setVersion(String value) { this.version = value; }

    @JsonProperty("build_date")
    public OffsetDateTime getBuildDate() { return buildDate; }
    @JsonProperty("build_date")
    public void setBuildDate(OffsetDateTime value) { this.buildDate = value; }

    @JsonProperty("graph_date")
    public OffsetDateTime getGraphDate() { return graphDate; }
    @JsonProperty("graph_date")
    public void setGraphDate(OffsetDateTime value) { this.graphDate = value; }
}
