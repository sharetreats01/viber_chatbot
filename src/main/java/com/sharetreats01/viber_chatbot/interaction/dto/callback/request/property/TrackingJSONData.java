package com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property;

import com.sharetreats01.viber_chatbot.tracking.utils.TrackingUtils;
import lombok.*;

import java.util.UUID;

@Getter
public class TrackingJSONData {
    private final UUID session;
    private Status status;

    public TrackingJSONData() {
        this.session = TrackingUtils.createSessionId();
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
