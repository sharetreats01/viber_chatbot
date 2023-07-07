package com.sharetreats01.viber_chatbot.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ScaleType {
    CROP("crop"),
    FILL("fill"),
    FIT("fit");

    private final String value;
    private static final Map<String, ScaleType> map = new HashMap<>();

    ScaleType(String value) {
        this.value = value;
    }

    static {
        for (ScaleType type : values()) {
            map.put(type.value, type);
        }
    }

    @JsonCreator
    public static ScaleType fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
