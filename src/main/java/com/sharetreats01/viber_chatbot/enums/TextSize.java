package com.sharetreats01.viber_chatbot.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum TextSize {
    SMALL("small"), REGULAR("regular"), LARGE("large");

    private final String value;
    private static final Map<String, TextSize> map = new HashMap<>();

    TextSize(String value) {
        this.value = value;
    }

    static {
        for (TextSize textSize : values()) {
            map.put(textSize.value, textSize);
        }
    }

    @JsonCreator
    public static TextSize fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
