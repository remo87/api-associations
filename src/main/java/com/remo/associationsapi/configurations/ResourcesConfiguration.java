package com.remo.associationsapi.configurations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.remo.associationsapi.models.Association;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
@Slf4j
public class ResourcesConfiguration {

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public Association loadJsonResource() {
        Association root = null;
        try {
            File jsonFile = new File("C:\\Code\\embl\\associations\\files\\associations.json");
            root = objectMapper.readValue(jsonFile, Association.class);
        } catch (JsonProcessingException e) {
            log.error("Error processing association file", e);
        } catch (IOException e) {
            log.error("Error reading association file", e);
        }
        return root;
    }
}
