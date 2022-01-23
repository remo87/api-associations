package com.remo.associationsapi.resolvers.association.query;

import com.remo.associationsapi.models.Association;
import com.remo.associationsapi.models.AssociationScore;
import com.remo.associationsapi.models.Datum;
import com.remo.associationsapi.models.Filter;
import com.remo.associationsapi.services.IAssociationService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssociationResolver implements GraphQLQueryResolver {

    @Autowired
    private IAssociationService associationService;

    public List<Datum> associations(Filter filter) {
        return associationService.getData(filter);
    }

    public AssociationScore scoresById(String id){
        return associationService.getScoresById(id);
    }
}
