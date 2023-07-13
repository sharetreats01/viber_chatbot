package com.sharetreats01.viber_chatbot.util;

import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
@RequiredArgsConstructor
public class TrackingDataUtils {
    private final UUIDGenerator uuidGenerator;
    private final String DELIMITER = ":";
    private final String DATA_DELIMITER = "_";

    public String getSession(String trackingData) {
        if (!StringUtils.hasText(trackingData))
            return null;
        return trackingData.split(DELIMITER)[0];
    }

    public String createTrackingData() {
        return createSession() + State.BRANDS.name();
    }

    public State getState(String trackingData) {
        if (!StringUtils.hasText(trackingData))
            return State.BRANDS;

        String[] parts = trackingData.split(DELIMITER);
        if (parts.length < 3)
            return State.PRODUCTS;
        String lastPart = parts[parts.length - 1];
        String[] lastState = lastPart.split(DATA_DELIMITER);

        return State.fromValue(lastState[0]);
    }

    public State getState(String trackingData, String input) {
        if (StringUtils.hasText(input) && StringUtils.pathEquals(input, State.TREAT.name())) {
            return State.TREAT;
        } else if (StringUtils.hasText(input)) {
            String[] parts = trackingData.split(DELIMITER);
            State state = State.fromValue(parts[parts.length - 1]);
            return state.next();
        } else {
            return null;
        }
    }

    public String updateNextState(String trackingData, State state) {
        if (!StringUtils.hasText(trackingData)) {
            return createTrackingData();
        }
        return trackingData + DELIMITER + state.next();
    }

    public String getData(String trackingData) {
        String[] parts = trackingData.split(DELIMITER);
        String[] lastParts = parts[parts.length - 1].split(DATA_DELIMITER);
        return lastParts[lastParts.length - 1];
    }

    public String updateState(String trackingData, State state) {
        return trackingData + DELIMITER + state;
    }

    public String updateData(String trackingData, String data) {
        return trackingData + DATA_DELIMITER + data.trim();
    }

    private String createSession() {
        return uuidGenerator.createTimeBasedUUID().toString();
    }
}
