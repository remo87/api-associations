package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Categories {
    @JsonProperty("clinical_precedence")
    private Double clinicalPrecedence;
    @JsonProperty("predicted_tractable")
    private Double predictedTractable;
    @JsonProperty("discovery_precedence")
    private Double discoveryPrecedence;
    @JsonProperty("predicted_tractable_med_low_confidence")
    private Double predictedTractableMedLowConfidence;
    @JsonProperty("predicted_tractable_high_confidence")
    private Double predictedTractableHighConfidence;
}