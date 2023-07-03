package com.sharetreats01.viber_chatbot;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AbstractMockTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T JsonToValue(Class<T> className, String jsonPath) {
        try {
            byte[] data = Files.readAllBytes(Paths.get("src/test/resources" + jsonPath));

            return objectMapper.readValue(data, className);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String JsonToString(String jsonPath) {
        try {
            return Files.readString(Paths.get("src/test/resources" + jsonPath));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
