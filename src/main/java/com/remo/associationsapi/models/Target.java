package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Target {
    @JsonProperty("tractability")
    private Tractability tractability;
    @JsonProperty("gene_info")
    private GeneInfo geneInfo;
    @JsonProperty("id")
    private String id;}
