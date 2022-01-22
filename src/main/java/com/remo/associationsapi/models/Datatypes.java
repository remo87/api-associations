package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Datatypes {
    @JsonProperty("literature")
    private Double literature;
    @JsonProperty("rna_expression")
    private Double rnaExpression;
    @JsonProperty("genetic_association")
    private Double geneticAssociation;
    @JsonProperty("somatic_mutation")
    private Double somaticMutation;
    @JsonProperty("known_drug")
    private Double knownDrug;
    @JsonProperty("animal_model")
    private Double animalModel;
    @JsonProperty("affected_pathway")
    private Double affectedPathway;
}
