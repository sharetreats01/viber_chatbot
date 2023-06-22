package com.sharetreats01.viber_chatbot.interaction.enums.internal.browser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum FooterType {
    DEFAULT("default"),
    HIDDEN("hidden")
    ;

    private final String value;
    private static final Map<String, FooterType> map = new HashMap<>();

    FooterType(String value) {
        this.value = value;
    }

    static {
        for (FooterType type : values()) {
            map.put(type.value, type);
        }
    }

    @JsonCreator
    public static FooterType fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
