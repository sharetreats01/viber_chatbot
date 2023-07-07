package com.sharetreats01.viber_chatbot.enums.internal.browser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ActionButton {
    FORWARD("forward"),
    SEND("send"),
    OPEN_EXTERNALLY("open-externally"),
    SEND_TO_BOT("send-to-bot"),
    NONE("none");

    private final String value;
    private static final Map<String, ActionButton> map = new HashMap<>();

    ActionButton(String value) {
        this.value = value;
    }

    static {
        for (ActionButton actionButton : values()) {
            map.put(actionButton.value, actionButton);
        }
    }

    @JsonCreator
    public static ActionButton fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
