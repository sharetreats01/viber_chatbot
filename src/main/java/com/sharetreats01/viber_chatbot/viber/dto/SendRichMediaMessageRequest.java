package com.sharetreats01.viber_chatbot.viber.dto;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Sender;
import lombok.Getter;

@Getter
public class SendRichMediaMessageRequest extends SendMessageRequest {
    private final String type = "rich_media";

    public SendRichMediaMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
    }
}
