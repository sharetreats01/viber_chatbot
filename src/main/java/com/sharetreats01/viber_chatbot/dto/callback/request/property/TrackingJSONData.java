package com.sharetreats01.viber_chatbot.dto.callback.request.property;

import com.sharetreats01.viber_chatbot.tracking.utils.TrackingUtils;
import lombok.*;

import java.util.UUID;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TrackingJSONData {
//    @EqualsAndHashCode.Exclude
    private final UUID session;
    private State state;

    public TrackingJSONData() {
        this.session = TrackingUtils.createSessionId();
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        if (state != null)
            return "{\"session\":" + "\"" + session + "\"" + "\"status\":" + "\"" + state.getValue() + "\"" + "}";
        return "{\"session\":" + "\"" + session + "\"" + "}";

    }
}
