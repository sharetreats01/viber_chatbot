package com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum State {
    NEW("new"),
    BRANDS("brands"),
    PRODUCTS("products"),
    PRODUCT_DETAIL("product_detail"),
    ORDER("order"),
    PAYMENT("payment");

    private final String value;
    private static final Map<String, State> map = new HashMap<>();

    State(String value) {
        this.value = value;
    }

    static {
        for (State state : values()) {
            map.put(state.value, state);
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
        int current = this.ordinal() - 1;

        if (1 < current)
            return values()[current - 1];
        return values()[1];
    }

    public State next() {
        int current = this.ordinal();

        if (current < values().length - 1)
            return values()[current + 1];
        return values()[values().length - 1];
    }
}
