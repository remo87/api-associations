package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Association {
    @JsonProperty("data_version")
    private String dataVersion;
    @JsonProperty("data")
    private List<Datum> data = new ArrayList<>();
    @JsonProperty("size")
    private Integer size;
}
