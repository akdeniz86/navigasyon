package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Tollways {
    private List<List<Long>> values;
    private List<SummaryElement> summary;

    @JsonProperty("values")
    public List<List<Long>> getValues() { return values; }
    @JsonProperty("values")
    public void setValues(List<List<Long>> value) { this.values = value; }

    @JsonProperty("summary")
    public List<SummaryElement> getSummary() { return summary; }
    @JsonProperty("summary")
    public void setSummary(List<SummaryElement> value) { this.summary = value; }
}
