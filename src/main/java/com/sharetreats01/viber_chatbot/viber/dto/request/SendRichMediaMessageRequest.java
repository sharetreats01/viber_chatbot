package com.sharetreats01.viber_chatbot.viber.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendRichMediaMessageRequest extends SendMessageRequest {
    private final String type = "rich_media";

    public SendRichMediaMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
    }
}
