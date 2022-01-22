package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EvidenceCount {
    @JsonProperty("datatypes")
    private Datatypes datatypes;
    @JsonProperty("total")
    private Double total;
    @JsonProperty("datasources")
    private Datasources datasources;
}
