package com.sharetreats01.viber_chatbot.botMessage.enums.favorite.metadata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Type {
    GIF("gif"),
    LINK("link"),
    VIDEO("video");

    private final String value;
    private static final Map<String, Type> map = new HashMap<>();

    Type(String value) {
        this.value = value;
    }

    static {
        for(Type type : values()) {
            map.put(type.value, type);
        }
    }

    @JsonCreator
    public static Type fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
