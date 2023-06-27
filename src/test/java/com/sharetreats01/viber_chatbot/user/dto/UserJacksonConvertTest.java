package com.sharetreats01.viber_chatbot.user.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserJacksonConvertTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void 유저_객체_직렬화_테스트() throws InvocationTargetException, InstantiationException, IllegalAccessException, JsonProcessingException {
        User user = UserFactory.create();

        String json = objectMapper.writeValueAsString(user);

        System.out.println(json);
        assertTrue(json.contains("\"id\":\"01234567890A=\""));
        assertTrue(json.contains("\"primary_device_os\":\"android 7.1\""));
    }

    @Test
    public void 유저_역직렬화_테스트() throws JsonProcessingException {
        String json = "{\"id\":\"01234567890A=\",\"name\":\"John McClane\",\"avatar\":\"http://avatar.example.com\",\"country\":\"UK\",\"language\":\"en\",\"primary_device_os\":\"android 7.1\",\"api_version\":1,\"viber_version\":\"6.5.0\",\"mcc\":1,\"mnc\":1,\"device_type\":\"iPhone9,4\"}";

        User user = objectMapper.readValue(json, User.class);

        assertEquals(user.getId(), "01234567890A=");
        assertEquals(user.getPrimaryDeviceOs(), "android 7.1");
        assertEquals(user.getViberVersion(), "6.5.0");
    }
}
