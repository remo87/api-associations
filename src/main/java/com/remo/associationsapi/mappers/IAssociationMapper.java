package com.remo.associationsapi.mappers;

import com.remo.associationsapi.dtos.DataListItemDto;
import com.remo.associationsapi.dtos.ScoresDto;
import com.remo.associationsapi.models.Datatypes;
import com.remo.associationsapi.models.Datum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IAssociationMapper {
    IAssociationMapper MAPPER = Mappers.getMapper(IAssociationMapper.class);

    @Mappings({
            @Mapping(source = "literature", target = "literature"),
            @Mapping(source = "rnaExpression", target = "rnaExpression"),
            @Mapping(source = "geneticAssociation", target = "geneticAssociation"),
            @Mapping(source = "somaticMutation", target = "somaticMutation"),
            @Mapping(source = "knownDrug", target = "knownDrug"),
            @Mapping(source = "animalModel", target = "animalModel"),
            @Mapping(source = "affectedPathway", target = "affectedPathway")
    })
    ScoresDto toScores(Datatypes datatypes);

    @Mappings({
            @Mapping(source = "target.id", target = "id"),
            @Mapping(source = "target.geneInfo.symbol", target = "symbol"),
            @Mapping(source = "target.geneInfo.name", target = "name"),
            @Mapping(source = "associationScore.overall", target = "overall"),
    })
    DataListItemDto toListItem(Datum datum);
}
