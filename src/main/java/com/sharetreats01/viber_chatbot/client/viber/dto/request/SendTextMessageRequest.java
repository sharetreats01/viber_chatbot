package com.sharetreats01.viber_chatbot.client.viber.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SendTextMessageRequest extends SendMessageRequest {
    private final String type = "text";
    private final String text;

    public SendTextMessageRequest(String receiver, String senderName, String senderAvatar, Integer minApiVersion, String text, String trackingData) {
        super(receiver, new Sender(senderName, senderAvatar), minApiVersion, trackingData);
        this.text = text;
    }

    public SendTextMessageRequest(String receiver, String senderName, String senderAvatar, String text, String trackingData) {
        super(receiver, new Sender(senderName, senderAvatar), null, trackingData);
        this.text = text;
    }
}
