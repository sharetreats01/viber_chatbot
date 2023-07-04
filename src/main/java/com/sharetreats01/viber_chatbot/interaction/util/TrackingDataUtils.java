package com.sharetreats01.viber_chatbot.interaction.util;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.State;

public class TrackingDataUtils {
    private static final String DELIMITER = ":";

    public static String getSession(String trackingData) {
        return trackingData.split(DELIMITER)[0];
    }

    public static State getState(String trackingData) {
        return State.fromValue(trackingData.split(DELIMITER)[1]);
    }

    public static String updateState(String trackingData, State newState) {
        String[] parts = trackingData.split(":");

        if (parts.length < 2) {
            return trackingData + ":" + newState.getValue();
        }

        parts[1] = newState.getValue();
        return String.join(":", parts);
    }
}
