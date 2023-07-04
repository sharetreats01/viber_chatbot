package com.sharetreats01.viber_chatbot.viber.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendUrlMessageRequest extends SendMessageRequest {
    private final String type = "url";
    private final String media;

    public SendUrlMessageRequest(String receiver, String senderName, String senderAvatar, Integer minApiVersion, String trackingData, String media) {
        super(receiver, new Sender(senderName, senderAvatar), minApiVersion, trackingData);
        this.media = media;
    }
}
