package com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    NEW("new"),
    BRANDS("brands"),
    PRODUCTS("products"),
    PRODUCT_DETAIL("product_detail"),
    ORDER("order"),
    PAYMENT("payment");

    private final String value;
    private static final Map<String, Status> map = new HashMap<>();

    Status(String value) {
        this.value = value;
    }

    static {
        for (Status status : values()) {
            map.put(status.value, status);
        }
    }

    @JsonCreator
    public static Status fromValue(String value) {
        return map.getOrDefault(value, NEW);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public Status prev() {
        int current = this.ordinal() - 1;

        if (1 < current)
            return values()[current - 1];
        return values()[1];
    }

    public Status next() {
        int current = this.ordinal();

        if (current < values().length - 1)
            return values()[current + 1];
        return values()[values().length - 1];
    }
}
