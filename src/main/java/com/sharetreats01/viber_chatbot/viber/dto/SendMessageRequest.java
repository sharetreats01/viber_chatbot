package com.sharetreats01.viber_chatbot.viber.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class SendMessageRequest {
    private final String receiver;
    private final Sender sender;
    private final String trackingData;
    private final Integer minApiVersion;

    public SendMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion) {
        this.receiver = receiver;
        this.sender = new Sender(senderName, senderAvatar);
        this.trackingData = trackingData;
        this.minApiVersion = minApiVersion;
    }

    @Getter
    @RequiredArgsConstructor
    private static class Sender {
        private final String name;
        private final String avatar;
    }
}
