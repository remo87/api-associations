package com.remo.associationsapi.services;

import com.remo.associationsapi.models.AssociationScore;
import com.remo.associationsapi.models.Datum;
import com.remo.associationsapi.models.Filter;

import java.util.List;

public interface IAssociationService {

    List<Datum> getData(Filter filter);

    AssociationScore getScoresById(String id);

}
