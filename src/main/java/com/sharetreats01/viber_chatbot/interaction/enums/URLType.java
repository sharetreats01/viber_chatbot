package com.sharetreats01.viber_chatbot.interaction.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum URLType {
    INTERNAL("internal"),
    EXTERNAL("external");

    private final String value;
    private final static Map<String, URLType> map = new HashMap<>();

    URLType(String value) {
        this.value = value;
    }

    static {
        for (URLType type : values()) {
            map.put(type.value, type);
        }
    }

    @JsonCreator
    public static URLType fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
