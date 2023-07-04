package com.sharetreats01.viber_chatbot.interaction.util;

import com.fasterxml.uuid.Generators;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.State;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TrackingDataUtils {
    private static final String DELIMITER = ":";
    private static final State DEFAULT_STATE = State.BRANDS;

    public static String getSession(String trackingData) {
        if (!StringUtils.hasText(trackingData))
            return null;
        return trackingData.split(DELIMITER)[0];
    }

    public static String createTrackingData() {
        return createSession() + ":" + DEFAULT_STATE.getValue();
    }

    public static State getState(String trackingData) {
        if (!StringUtils.hasText(trackingData))
            return DEFAULT_STATE;

        String[] parts = trackingData.split(":");
        return State.fromValue(parts[parts.length - 1]);
    }

    public static List<State> getStates(String trackingData) {
        if (!StringUtils.hasText(trackingData))
            return Collections.emptyList();

        String[] parts = trackingData.split(":");
        return Arrays.stream(parts).map(State::fromValue).collect(Collectors.toList());
    }

    public static String updateState(String trackingData, State state, String value) {
        if (!StringUtils.hasText(trackingData)) {
            return createTrackingData();
        }

        return trackingData + DELIMITER + state.getValue() + DELIMITER + value;
    }


    public static String removeLastState(String trackingData) {
        if (!StringUtils.hasText(trackingData))
            return null;

        int lastDelimiterIndex = trackingData.lastIndexOf(DELIMITER);
        if (0 < lastDelimiterIndex)
            return trackingData.substring(0, lastDelimiterIndex);
        return trackingData;
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
