package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class SendMessageRequest {
    private final String receiver;
    private final Sender sender;
    @JsonProperty("tracking_data")
    private final String trackingData;
    @JsonProperty("min_api_version")
    private final Integer minApiVersion;
    private String keyboard;

    public SendMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion) {
        this.receiver = receiver;
        this.sender = new Sender(senderName, senderAvatar);
        this.trackingData = trackingData;
        this.minApiVersion = minApiVersion;
        this.keyboard = null;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    @Getter
    @RequiredArgsConstructor
    @ToString
    private static class Sender {
        private final String name;
        private final String avatar;
    }
}
