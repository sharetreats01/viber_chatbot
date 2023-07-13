package com.sharetreats01.viber_chatbot.infra.viber.client;

import com.sharetreats01.viber_chatbot.infra.viber.dto.response.SendMessageResponse;
import com.sharetreats01.viber_chatbot.infra.viber.enums.Status;
import com.sharetreats01.viber_chatbot.infra.viber.exception.ViberException;
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
