package com.sharetreats01.viber_chatbot.util;

import com.fasterxml.uuid.Generators;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TrackingDataUtils {
    private static final String DELIMITER = ":";
    private static final String DATA_DELIMITER = "-";
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
            return State.NEW;

        String[] parts = trackingData.split(":");
        if (parts.length < 2)
            return DEFAULT_STATE;
        String lastPart = parts[parts.length - 1];
        String[] lastState = lastPart.split("-");

        return lastState.length > 0 ? State.fromValue(lastState[0]) : null;
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

        return trackingData + DATA_DELIMITER + value + DELIMITER + state.getValue();
    }

    public static String updateNextState(String trackingData, State state) {
        if (!StringUtils.hasText(trackingData)) {
            return createTrackingData();
        }
        return trackingData + DELIMITER + state.next().getValue();
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
