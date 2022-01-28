package com.remo.associationsapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoresDto {
        private Double literature;
        private Double rnaExpression;
        private Double geneticAssociation;
        private Double somaticMutation;
        private Double knownDrug;
        private Double animalModel;
        private Double affectedPathway;
}
