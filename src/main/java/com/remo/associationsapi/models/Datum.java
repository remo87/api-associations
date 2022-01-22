package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Datum {
    @JsonProperty("target")
    private Target target;
    @JsonProperty("association_score")
    private AssociationScore associationScore;
    @JsonProperty("disease")
    private Disease disease;
    @JsonProperty("is_direct")
    private Boolean isDirect;
    @JsonProperty("evidence_count")
    private EvidenceCount evidenceCount;
    @JsonProperty("id")
    private String id;
}
