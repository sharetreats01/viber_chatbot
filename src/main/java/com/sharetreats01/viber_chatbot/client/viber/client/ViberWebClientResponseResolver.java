package com.sharetreats01.viber_chatbot.client.viber.client;

import com.sharetreats01.viber_chatbot.client.viber.dto.response.SendMessageResponse;
import com.sharetreats01.viber_chatbot.client.viber.exception.ViberException;
import com.sharetreats01.viber_chatbot.client.viber.enums.Status;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ViberWebClientResponseResolver {
    public static void handleSendMessageResponse(SendMessageResponse response) {
        if (!response.getStatus().equals(Status.OK)) {
            log.error("Code: {} Reason: {}", response.getStatus().getValue(), response.getStatus().getMessage());
            throw new ViberException(response.getStatus().getMessage());
        }
    }
}
