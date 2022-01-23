package com.remo.associationsapi.repositories;

import com.remo.associationsapi.models.AssociationScore;
import com.remo.associationsapi.models.Datum;
import com.remo.associationsapi.models.Filter;

import java.util.List;

public interface IAssociationRepository {
    List<Datum> getData(Filter filter);
    List<Datum> getData();

    AssociationScore getScoresById(String id);
}
