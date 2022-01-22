package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Disease {
    @JsonProperty("efo_info")
    private EfoInfo efoInfo;
    @JsonProperty("id")
    private String id;
}
