package com.sharetreats01.viber_chatbot.botMessage.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum MediaType {
    PICTURE("picture"),
    GIF("gif");

    private final String value;
    private static final Map<String, MediaType> map = new HashMap<>();

    MediaType(String value) {
        this.value = value;
    }

    static {
        for (MediaType type : values()) {
            map.put(type.value, type);
        }
    }

    @JsonCreator
    public static MediaType fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
