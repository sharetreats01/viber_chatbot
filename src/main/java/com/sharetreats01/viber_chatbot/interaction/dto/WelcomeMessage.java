package com.sharetreats01.viber_chatbot.interaction.dto;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Keyboard;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class WelcomeMessage {
    private final Sender sender;
    private final String trackingData;
    private final String type;
    private final String text;
    private final String media;
    private final String thumbnail;
    private Keyboard keyboard;

    @Builder
    public WelcomeMessage(String senderName, String senderAvatar, String trackingData, String type, String text, String media, String thumbnail, Keyboard keyboard) {
        this.sender = new Sender(senderName, senderAvatar);
        this.trackingData = trackingData;
        this.type = type;
        this.text = text;
        this.media = media;
        this.thumbnail = thumbnail;
        this.keyboard = keyboard;
    }

    @Getter
    @RequiredArgsConstructor
    private static class Sender {
        private final String name;
        private final String avatar;
    }
}
