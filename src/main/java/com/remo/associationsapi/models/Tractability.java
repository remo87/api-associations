package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Tractability {
    @JsonProperty("smallmolecule")
    private Smallmolecule smallmolecule;
    @JsonProperty("antibody")
    private Antibody antibody;
}
