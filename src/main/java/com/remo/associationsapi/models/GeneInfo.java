package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeneInfo {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
}
