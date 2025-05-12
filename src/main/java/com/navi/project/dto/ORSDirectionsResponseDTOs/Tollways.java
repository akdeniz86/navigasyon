package com.navi.project.dto.ORSDirectionsResponseDTOs;

import java.util.List;

public class Tollways {
    private List<List<Integer>> values;
    private List<SummaryElement> summary;

    public List<List<Integer>> getValues() { return values; }
    public void setValues(List<List<Integer>> value) { this.values = value; }

    public List<SummaryElement> getSummary() { return summary; }
    public void setSummary(List<SummaryElement> value) { this.summary = value; }
}
