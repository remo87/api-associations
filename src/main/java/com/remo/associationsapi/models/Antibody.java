package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Antibody {
    @JsonProperty("top_category")
    private String topCategory;
    @JsonProperty("buckets")
    private List<Integer> buckets = new ArrayList<>();
    @JsonProperty("categories")
    private Categories categories;
}

