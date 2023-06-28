package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.request.property.Keyboard;
import lombok.Getter;

@Getter
public class SendTextMessageRequest extends SendMessageRequest {
    private final String type = "text";
    private final String text;

    public SendTextMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, String text) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
        this.text = text;
    }

    public SendTextMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, String text, Keyboard keyboard) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion, keyboard);
        this.text = text;
    }
}
