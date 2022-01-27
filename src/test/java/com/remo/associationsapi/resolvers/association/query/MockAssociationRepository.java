package com.remo.associationsapi.resolvers.association.query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.remo.associationsapi.AssociationsApiApplication;
import com.remo.associationsapi.models.Association;
import com.remo.associationsapi.models.AssociationScore;
import com.remo.associationsapi.models.Datum;
import com.remo.associationsapi.models.Filter;
import com.remo.associationsapi.repositories.IAssociationRepository;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Repository
@Primary
@Slf4j
@Import(AssociationsApiApplication.class)
public class MockAssociationRepository implements IAssociationRepository {

    private static final String GRAPHQL_MOCK_DATA = "graphql/resolver/query/mockdata/associations.json";

    private Association association;

    public MockAssociationRepository() {
        try {
            String content = read(GRAPHQL_MOCK_DATA);
            association = new ObjectMapper().readValue(content, Association.class);
        } catch (JsonProcessingException e) {
            log.error("Error processing association file", e);
        } catch (IOException e) {
            log.error("Error reading association file", e);
        }
    }

    @Override
    public List<Datum> getData(Filter filter) {
        return association.getData();
    }

    @Override
    public List<Datum> getData() {
        return association.getData();
    }

    @Override
    public AssociationScore getScoresById(String id) {
        return association
                .getData()
                .stream()
                .filter(data -> data.getTarget().getId().equals(id))
                .findFirst()
                .orElseThrow()
                .getAssociationScore();
    }

    private String read(String location) throws IOException {
        return IOUtils.toString(
                new ClassPathResource(location).getInputStream(), StandardCharsets.UTF_8);
    }
}
