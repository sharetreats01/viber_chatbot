package com.sharetreats01.viber_chatbot.interaction.enums;

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
            map.put(event.getValue(), event);
        }
    }

//    @JsonCreator
    public static Event fromValue(String value) {
        return map.getOrDefault(value, null);
    }
    @JsonCreator
    public static Event forValue(String value) {
        for (Event event : values()) {
            if (event.getValue().equals(value)) {
                return event;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
