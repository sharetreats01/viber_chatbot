package com.sharetreats01.viber_chatbot.interaction.enums.internal.browser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum TitleType {
    DOMAIN("domain"),
    DEFAULT("default");

    private final String value;
    private static final Map<String, TitleType> map = new HashMap<>();

    TitleType(String value) {
        this.value = value;
    }

    static {
        for (TitleType type : values()) {
            map.put(type.value, type);
        }
    }

    @JsonCreator
    public static TitleType fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
