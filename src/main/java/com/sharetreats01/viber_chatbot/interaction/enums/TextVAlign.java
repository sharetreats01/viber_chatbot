package com.sharetreats01.viber_chatbot.interaction.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum TextVAlign {
    TOP("top"),
    MIDDLE("middle"),
    BOTTOM("bottom");

    private final String value;
    private static final Map<String, TextVAlign> map = new HashMap<>();

    TextVAlign(String value) {
        this.value = value;
    }

    static {
        for (TextVAlign textVAlign : values()) {
            map.put(textVAlign.value, textVAlign);
        }
    }

    @JsonCreator
    public static TextVAlign fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
