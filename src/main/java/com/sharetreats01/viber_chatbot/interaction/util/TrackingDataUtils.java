package com.sharetreats01.viber_chatbot.interaction.util;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Status;

public class TrackingDataUtils {
    public static Status parseStatus(String data) {
        for (Status status : Status.values()) {
            int lastStatusIndex =  data.lastIndexOf(status.getValue());

        }
        return Status.NEW;
    }
}
