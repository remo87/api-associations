package com.remo.associationsapi.services;

import com.remo.associationsapi.models.Association;
import com.remo.associationsapi.models.AssociationScore;
import com.remo.associationsapi.models.Datum;
import com.remo.associationsapi.models.Filter;
import com.remo.associationsapi.repositories.IAssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssociationService implements IAssociationService {

    @Autowired
    private IAssociationRepository associationRepository;

    @Override
    public List<Datum> getData(Filter filter) {
        if(filter == null)
            return associationRepository.getData();

        return associationRepository.getData(filter);
    }

    @Override
    public AssociationScore getScoresById(String id) {
        return associationRepository.getScoresById(id);
    }
}
