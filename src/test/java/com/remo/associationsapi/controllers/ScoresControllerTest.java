package com.remo.associationsapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MockAssociationRepository.class)
class ScoresControllerTest {

    @Autowired
    private TestRestTemplate client;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void getAllData() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String expected = read("classpath:controllers/response/get_associations.json");

        ResponseEntity<String> response = client.getForEntity("/api/scores", String.class);
        String body = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mapper.readTree(expected), mapper.readTree(body));
    }

    @Test
    void getScoresById() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String expected = read("classpath:controllers/response/get_scores_by_id.json");

        ResponseEntity<String> response = client.getForEntity("/api/scores/ENSG00000003436", String.class);
        String body = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mapper.readTree(expected), mapper.readTree(body));

    }

    private String read(String resource) {
        String value = "";
        try {
            InputStream file = resourceLoader.getResource(resource).getInputStream();
            String msg = StreamUtils.copyToString(file, Charset.defaultCharset());
            value = msg;
        } catch (JsonProcessingException e) {
            log.error("Error processing association file", e);
        } catch (IOException e) {
            log.error("Error reading association file", e);
        } catch (RuntimeException e) {
            log.error("Error reading association file", e);
        }
        return value;
    }
}