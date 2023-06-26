package com.sharetreats01.viber_chatbot.viber.dto;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Sender;
import lombok.Getter;

@Getter
public class SendStickerMessageRequest extends SendMessageRequest {
    private final String type = "sticker";
    private final Integer stickerId;

    public SendStickerMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, Integer stickerId) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
        this.stickerId = stickerId;
    }
}
