package com.sharetreats01.viber_chatbot.viber.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class SendTextMessageRequest extends SendMessageRequest {
    private final String type = "text";
    private final String text;

    public SendTextMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, String text) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
        this.text = text;
    }
}
