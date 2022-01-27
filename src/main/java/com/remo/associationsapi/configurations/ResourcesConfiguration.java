package com.remo.associationsapi.configurations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.remo.associationsapi.models.Association;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

@Configuration
@Slf4j
public class ResourcesConfiguration {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${ASSOCIATIONS_FILE}")
    private String filePath;

    public static String URLReader(URL url) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;

        InputStream in = url.openStream();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } finally {
            in.close();
        }

        return sb.toString();
    }

    @Bean
    public Association loadJsonResource() {
        Association root = new Association();
        try {
            URL associationFileUrl = new URL(filePath);
            String fileContent = URLReader(associationFileUrl);
            root = objectMapper.readValue(associationFileUrl, Association.class);
        } catch (JsonProcessingException e) {
            log.error("Error processing association file", e);
            root.setData(new ArrayList<>());
        } catch (IOException e) {
            log.error("Error reading association file", e);
            root.setData(new ArrayList<>());
        }
        return root;
    }
}
