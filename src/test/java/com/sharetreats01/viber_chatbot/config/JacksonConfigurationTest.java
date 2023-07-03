package com.sharetreats01.viber_chatbot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JacksonConfigurationTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void 스네이크_케이스_설정() {
        assertEquals(PropertyNamingStrategies.SNAKE_CASE, objectMapper.getPropertyNamingStrategy());
    }
}
