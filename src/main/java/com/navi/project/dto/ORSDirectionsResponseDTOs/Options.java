package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Options {
    private List<Object> avoidFeatures;

    @JsonProperty("avoid_features")
    public List<Object> getAvoidFeatures() { return avoidFeatures; }
    @JsonProperty("avoid_features")
    public void setAvoidFeatures(List<Object> value) { this.avoidFeatures = value; }
}
