package com.remo.associationsapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.remo.associationsapi.dtos.DataListItemDto;
import com.remo.associationsapi.models.Association;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MockAssociationRepository.class)
class AssociationsControllerTest {

    @Autowired
    private TestRestTemplate client;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void getAllData() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String expected = read("classpath:controllers/response/get_alldata.json");

        ResponseEntity<String> response = client.getForEntity("/api/associations", String.class);
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