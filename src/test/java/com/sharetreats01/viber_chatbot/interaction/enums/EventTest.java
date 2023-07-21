package com.sharetreats01.viber_chatbot.interaction.enums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharetreats01.viber_chatbot.botMessage.enums.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFromValue() {
        assertEquals(Event.DELIVERED, Event.fromValue("delivered"));
        assertEquals(Event.SEEN, Event.fromValue("seen"));
        assertEquals(Event.FAILED, Event.fromValue("failed"));
        assertEquals(Event.SUBSCRIBED, Event.fromValue("subscribed"));
        assertEquals(Event.UNSUBSCRIBED, Event.fromValue("unsubscribed"));
        assertEquals(Event.CONVERSATION_STARTED, Event.fromValue("conversation_started"));
        assertEquals(Event.MESSAGE, Event.fromValue("message"));

        assertNull(Event.fromValue("null"));
    }

    @Test
    public void testDeserialize() throws Exception {
        String json = "\"delivered\"";
        Event event = objectMapper.readValue(json, Event.class);
        assertEquals(Event.DELIVERED, event);
    }

}