package com.sharetreats01.viber_chatbot.enums.internal.browser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Mode {
    FULLSCREEN("fullscreen"),
    FULLSCREEN_PORTRAIT("fullscreen-portrait"),
    FULLSCREEN_LANDSCAPE("fullscreen-landscape"),
    PARTIAL_SIZE("partial-size")
    ;

    private final String value;
    private static final Map<String, Mode> map = new HashMap<>();

    Mode(String value) {
        this.value = value;
    }

    static {
        for (Mode mode : values()) {
            map.put(mode.value, mode);
        }
    }

    @JsonCreator
    public static Mode fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
