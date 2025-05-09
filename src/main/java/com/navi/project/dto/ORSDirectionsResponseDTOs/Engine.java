package com.navi.project.dto.ORSDirectionsResponseDTOs;

import java.time.OffsetDateTime;

public class Engine {
    private String version;
    private OffsetDateTime buildDate;
    private OffsetDateTime graphDate;

    public String getVersion() { return version; }
    public void setVersion(String value) { this.version = value; }

    public OffsetDateTime getBuildDate() { return buildDate; }
    public void setBuildDate(OffsetDateTime value) { this.buildDate = value; }

    public OffsetDateTime getGraphDate() { return graphDate; }
    public void setGraphDate(OffsetDateTime value) { this.graphDate = value; }
}
