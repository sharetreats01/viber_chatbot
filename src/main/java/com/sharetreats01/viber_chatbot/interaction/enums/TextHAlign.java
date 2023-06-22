package com.sharetreats01.viber_chatbot.interaction.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum TextHAlign {
    LEFT("left"),
    RIGHT("right"),
    CENTER("center");

    private final String value;
    private static final Map<String, TextHAlign> map = new HashMap<>();

    TextHAlign(String value) {
        this.value = value;
    }

    static {
        for (TextHAlign textHAlign : values()) {
            map.put(textHAlign.value, textHAlign);
        }
    }

    @JsonCreator
    public static TextHAlign fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
