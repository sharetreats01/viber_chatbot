package com.sharetreats01.viber_chatbot.botMessage.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Event {
    DELIVERED("delivered"),
    SEEN("seen"),
    FAILED("failed"),
    SUBSCRIBED("subscribed"),
    UNSUBSCRIBED("unsubscribed"),
    CONVERSATION_STARTED("conversation_started"),
    MESSAGE("message");

    private final String value;

    Event(String value) {
        this.value = value;
    }

    private static final Map<String, Event> map = new HashMap<>();

    static {
        for (Event event : values()) {
            map.put(event.value, event);
        }
    }

    @JsonCreator
    public static Event fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
