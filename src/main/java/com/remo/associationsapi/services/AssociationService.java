package com.remo.associationsapi.services;

import com.remo.associationsapi.models.*;
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
    public List<Datum> getData() {
        return associationRepository.getData();
    }

    @Override
    public Datatypes getScoresById(String id) {
        return associationRepository.getScoresById(id).getDatatypes();
    }
}
