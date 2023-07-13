package com.sharetreats01.viber_chatbot.util;

import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;


@Component
@RequiredArgsConstructor
public class TrackingDataUtils {
    private final Map<State, State> handlerPath;
    private final UUIDGenerator uuidGenerator;
    private final String DELIMITER = ":";
    private final String DATA_DELIMITER = "_";

    public String getSession(String trackingData) {
        if (!StringUtils.hasText(trackingData))
            return null;
        return trackingData.split(DELIMITER)[0];
    }

    public String createTrackingData() {
        return createSession() + DELIMITER + State.BRANDS.name();
    }

    public State getNextState(String trackingData, String input) {
        if (!StringUtils.hasText(trackingData)) return State.BRANDS;

        String lastPart = getLastPart(trackingData);
        if (State.TREAT.name().equals(input)) return State.TREAT;
        return handlerPath.get(State.fromValue(lastPart));
    }

    private String getLastPart(String trackingData) {
        String[] parts = trackingData.split(DELIMITER);
        String lastPart = parts[parts.length - 1];
        return lastPart.split(DELIMITER)[0];
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

    public String updateNextState(String trackingData, State state) {
        if (!StringUtils.hasText(trackingData)) {
            return createTrackingData();
        }
        return trackingData + DELIMITER + state.next();
    }

    public String updateTrackingData(String trackingData, String data) {
        return trackingData + DATA_DELIMITER + data.trim() + DELIMITER + getNextState(trackingData, data);
    }

    private String createSession() {
        return uuidGenerator.createTimeBasedUUID().toString();
    }
}
