package com.sharetreats01.viber_chatbot.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum URLMediaType {
    NOT_MEDIA("not-media"),
    VIDEO("video"),
    GIF("gif"),
    PICTURE("picture");

    private final String value;
    private static final Map<String, URLMediaType> map = new HashMap<>();

    URLMediaType(String value) {
        this.value = value;
    }

    static {
        for (URLMediaType type : values()) {
            map.put(type.value, type);
        }
    }

    @JsonCreator
    public static URLMediaType fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
