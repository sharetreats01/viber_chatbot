package com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property;

import java.util.HashMap;
import java.util.Map;

public enum Tracking {
    SUBSCRIBE("subscribe"), CATEGORY("category"), BRAND("brand"), PRODUCT("product"), ORDER("order"), PAYMENT("payment");

    private final String value;
    private static final Map<String, Tracking> map = new HashMap<>();

    Tracking(String value) {
        this.value = value;
    }

    static {
        for (Tracking tracking : values()) {
            map.put(tracking.value, tracking);
        }
    }

    public static Tracking fromValue(String value) {
        return map.getOrDefault(value, null);
    }

    public static Tracking fromTrackingData(String trackingData) {
        for (Tracking tracking : values()) {
            if (trackingData.startsWith(tracking.value))
                return tracking;
        }

        return SUBSCRIBE;
    }
}
