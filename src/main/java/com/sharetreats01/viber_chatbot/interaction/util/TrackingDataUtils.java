package com.sharetreats01.viber_chatbot.interaction.util;

import com.fasterxml.uuid.Generators;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.State;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class TrackingDataUtils {
    private static final String DELIMITER = ":";
    private static final State DEFAULT_STATE = State.BRANDS;

    public static String getSession(String trackingData) {
        return trackingData.split(DELIMITER)[0];
    }

    public static String createTrackingData() {
        return createSession() + ":" + DEFAULT_STATE.getValue();
    }

    public static State getState(String trackingData) {
        if (!StringUtils.hasText(trackingData)) {
            return DEFAULT_STATE;
        }

        return State.fromValue(trackingData.split(DELIMITER)[1]);
    }

    public static String updateState(String trackingData, State newState) {
        if (!StringUtils.hasText(trackingData)) {
            return createTrackingData();
        }

        String[] parts = trackingData.split(":");

        if (parts.length < 2) {
            return trackingData + ":" + newState.getValue();
        }

        parts[1] = newState.getValue();
        return String.join(":", parts);
    }

    private static UUID createSession() {
        UUID uuid = Generators.timeBasedGenerator().generate();
        String[] uuidArr = uuid.toString().split("-");
        String uuidStr = uuidArr[2] + uuidArr[1] + uuidArr[0] + uuidArr[3] + uuidArr[4];
        StringBuilder sb = new StringBuilder(uuidStr);
        sb.insert(8, "-");
        sb.insert(13, "-");
        sb.insert(18, "-");
        sb.insert(23, "-");
        uuid = UUID.fromString(sb.toString());

        return uuid;
    }
}
