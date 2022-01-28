package com.remo.associationsapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.remo.associationsapi.AssociationsApiApplication;
import com.remo.associationsapi.models.Association;
import com.remo.associationsapi.models.AssociationScore;
import com.remo.associationsapi.models.Datum;
import com.remo.associationsapi.models.Filter;
import com.remo.associationsapi.repositories.IAssociationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
@Primary
@Slf4j
@Import(AssociationsApiApplication.class)
public class MockAssociationRepository implements IAssociationRepository {

    private Association association;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("classpath:controllers/mockdata/associations.json")
    private Resource resource;

    public void loadAssociations() {
        try {
            File file = resource.getFile();
            association = new ObjectMapper().readValue(file, Association.class);
        } catch (JsonProcessingException e) {
            log.error("Error processing association file", e);
        } catch (IOException e) {
            log.error("Error reading association file", e);
        } catch (RuntimeException e) {
            log.error("Error reading association file", e);
        }
    }

    @Override
    public List<Datum> getData(Filter filter) {
        loadAssociations();
        return association.getData();
    }

    @Override
    public List<Datum> getData() {
        loadAssociations();
        return association.getData();
    }

    @Override
    public AssociationScore getScoresById(String id) {
        loadAssociations();
        return association
                .getData()
                .stream()
                .filter(data -> data.getTarget().getId().equals(id))
                .findFirst()
                .orElseThrow()
                .getAssociationScore();
    }
}
