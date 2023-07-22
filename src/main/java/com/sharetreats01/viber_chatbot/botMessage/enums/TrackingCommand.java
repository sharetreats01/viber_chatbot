package com.sharetreats01.viber_chatbot.botMessage.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public enum TrackingCommand {
    BRAND("brand", new String[]{"-l", "-i"}),
    PRODUCT("product", new String[]{"-l", "-i"}),
    ORDER("order", new String[]{}),
    PAYMENT("payment", new String[]{}),
    POINT("point", new String[]{}),
    DISCOUNT_CODE("discount_code", new String[]{});

    private final String value;
    private final String[] options;
    private static final Map<String, TrackingCommand> map = new HashMap<>();

    static {
        for (TrackingCommand status : values()) {
            map.put(status.value, status);
        }
    }

    @JsonCreator
    public static TrackingCommand fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public String[] getOptions() {
        return options;
    }
}
