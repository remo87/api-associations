package com.remo.associationsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AssociationScore {
    @JsonProperty("datatypes")
    private Datatypes datatypes;
    @JsonProperty("overall")
    private Double overall;
    @JsonProperty("datasources")
    private Datasources datasources;
}