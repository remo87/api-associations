package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EfoInfo {
    @JsonProperty("therapeutic_area")
    private TherapeuticArea therapeuticArea;
    @JsonProperty("path")
    private List<List<String>> path = new ArrayList<>();
    @JsonProperty("label")
    private String label;
}
