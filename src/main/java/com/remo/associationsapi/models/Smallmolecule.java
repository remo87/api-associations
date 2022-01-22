package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Smallmolecule {
    @JsonProperty("top_category")
    private String topCategory;
    @JsonProperty("small_molecule_genome_member")
    private Boolean smallMoleculeGenomeMember;
    @JsonProperty("buckets")
    private List<Integer> buckets = new ArrayList<>();
    @JsonProperty("high_quality_compounds")
    private Integer highQualityCompounds;
    @JsonProperty("ensemble")
    private Double ensemble;
    @JsonProperty("categories")
    private Categories categories;
}
