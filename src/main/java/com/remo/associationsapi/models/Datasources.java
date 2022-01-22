package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Datasources {
    @JsonProperty("progeny")
    private Double progeny;
    @JsonProperty("sysbio")
    private Double sysbio;
    @JsonProperty("expression_atlas")
    private Double expressionAtlas;
    @JsonProperty("europepmc")
    private Double europepmc;
    @JsonProperty("intogen")
    private Double intogen;
    @JsonProperty("phewas_catalog")
    private Double phewasCatalog;
    @JsonProperty("uniprot_literature")
    private Double uniprotLiterature;
    @JsonProperty("phenodigm")
    private Double phenodigm;
    @JsonProperty("eva")
    private Double eva;
    @JsonProperty("gene2phenotype")
    private Double geneToPhenotype;
    @JsonProperty("gwas_catalog")
    private Double gwasCatalog;
    @JsonProperty("slapenrich")
    private Double slapenrich;
    @JsonProperty("genomics_england")
    private Double genomicsEngland;
    @JsonProperty("postgap")
    private Double postgap;
    @JsonProperty("uniprot")
    private Double uniprot;
    @JsonProperty("chembl")
    private Double chembl;
    @JsonProperty("cancer_gene_census")
    private Double cancerGeneCensus;
    @JsonProperty("reactome")
    private Double reactome;
    @JsonProperty("uniprot_somatic")
    private Double uniprotSomatic;
    @JsonProperty("eva_somatic")
    private Double evaSomatic;
    @JsonProperty("crispr")
    private Double crispr;
}
