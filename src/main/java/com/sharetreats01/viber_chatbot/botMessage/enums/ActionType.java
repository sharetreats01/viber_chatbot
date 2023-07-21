package com.sharetreats01.viber_chatbot.botMessage.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ActionType {
    REPLY("reply"),
    OPEN_URL("open-url"),
    LOCATION_PICKER("location-picker"),
    SHARE_PHONE("share_phone"),
    NONE("none");

    private final String value;
    private static final Map<String, ActionType> map = new HashMap<>();

    ActionType(String value) {
        this.value = value;
    }

    static {
        for (ActionType type : values()) {
            map.put(type.value, type);
        }
    }

    @JsonCreator
    public static ActionType fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
