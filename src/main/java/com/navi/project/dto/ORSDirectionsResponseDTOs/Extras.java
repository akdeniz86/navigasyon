package com.navi.project.dto.ORSDirectionsResponseDTOs;

import com.fasterxml.jackson.annotation.*;

public class Extras {
    private Tollways tollways;

    @JsonProperty("tollways")
    public Tollways getTollways() { return tollways; }
    @JsonProperty("tollways")
    public void setTollways(Tollways value) { this.tollways = value; }
}
