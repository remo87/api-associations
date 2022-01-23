package com.remo.associationsapi.repositories;

import com.remo.associationsapi.models.Association;
import com.remo.associationsapi.models.AssociationScore;
import com.remo.associationsapi.models.Datum;
import com.remo.associationsapi.models.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AssociationRepository implements IAssociationRepository {

    @Autowired
    private Association associationData;

    @Override
    public List<Datum> getData(Filter filter) {

        //if the limit is not specified we will take all values
        int limit = filter.getTake() != 0 ? filter.getTake() : associationData.getSize();

        return associationData
                .getData()
                .stream()
                .skip(filter.getSkip())
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<Datum> getData() {
        return associationData.getData();
    }

    @Override
    public AssociationScore getScoresById(String id) {
        return associationData
                .getData()
                .stream()
                .filter(data -> data.getTarget().getId().   equals(id))
                .findFirst()
                .orElseThrow()
                .getAssociationScore();
    }
}
