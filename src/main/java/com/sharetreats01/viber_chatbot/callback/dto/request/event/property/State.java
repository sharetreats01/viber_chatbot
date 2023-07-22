package com.sharetreats01.viber_chatbot.callback.dto.request.event.property;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum State {
    NEW("new"),
    BRANDS("brands"),
    PRODUCTS("products"),
    DETAIL("detail"),
    TREAT("treat");
    private final String value;
    private static final Map<String, State> map = new HashMap<>();

    State(String value) {
        this.value = value;
    }

    static {
        for (State state : values()) {
            map.put(state.name(), state);
        }
    }

    @JsonCreator
    public static State fromValue(String value) {
        return map.getOrDefault(value, NEW);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public State prev() {
        int current = this.ordinal();

        if (0 == current)
            return values()[0];
        return values()[current - 1];
    }

    public State next() {
        int current = this.ordinal();

        if (current == values().length - 1)
            return values()[current];
        return values()[current + 1];
    }
}
