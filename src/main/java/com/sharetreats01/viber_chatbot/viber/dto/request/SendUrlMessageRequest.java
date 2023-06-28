package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.sharetreats01.viber_chatbot.viber.dto.request.property.Keyboard;
import lombok.Getter;

@Getter
public class SendUrlMessageRequest extends SendMessageRequest {
    private final String type = "url";
    private final String media;

    public SendUrlMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, String media) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
        this.media = media;
    }

    public SendUrlMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, String media, Keyboard keyboard) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion, keyboard);
        this.media = media;
    }
}
