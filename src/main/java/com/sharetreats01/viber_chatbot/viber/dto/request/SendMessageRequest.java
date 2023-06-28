package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.viber.dto.request.property.Keyboard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class SendMessageRequest {
    private final String receiver;
    private final Sender sender;
    @JsonProperty("tracking_data")
    private final String trackingData;
    @JsonProperty("min_api_version")
    private final Integer minApiVersion;
    private final Keyboard keyboard;

    public SendMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion) {
        this.receiver = receiver;
        this.sender = new Sender(senderName, senderAvatar);
        this.trackingData = trackingData;
        this.minApiVersion = minApiVersion;
        this.keyboard = null;
    }

    public SendMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, Keyboard keyboard) {
        this.receiver = receiver;
        this.sender = new Sender(senderName, senderAvatar);
        this.trackingData = trackingData;
        this.minApiVersion = minApiVersion;
        this.keyboard = keyboard;
    }

    @Getter
    @RequiredArgsConstructor
    private static class Sender {
        private final String name;
        private final String avatar;
    }
}
