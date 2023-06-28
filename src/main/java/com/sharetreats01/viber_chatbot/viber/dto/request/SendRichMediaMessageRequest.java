package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.request.property.Keyboard;
import lombok.Getter;

@Getter
public class SendRichMediaMessageRequest extends SendMessageRequest {
    private final String type = "rich_media";

    public SendRichMediaMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
    }

    public SendRichMediaMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, Keyboard keyboard) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion, keyboard);
    }
}
