package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.request.property.Keyboard;
import lombok.Getter;

@Getter
public class SendStickerMessageRequest extends SendMessageRequest {
    private final String type = "sticker";
    @JsonProperty("sticker_id")
    private final Integer stickerId;

    public SendStickerMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, Integer stickerId) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
        this.stickerId = stickerId;
    }

    public SendStickerMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, Integer stickerId, Keyboard keyboard) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion, keyboard);
        this.stickerId = stickerId;
    }
}
