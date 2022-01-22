package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class TherapeuticArea {
    @JsonProperty("labels")
    private List<String> labels = new ArrayList<>();
    @JsonProperty("codes")
    private List<String> codes = new ArrayList<>();
}
