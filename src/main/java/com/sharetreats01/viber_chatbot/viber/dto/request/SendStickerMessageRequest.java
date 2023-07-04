package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendStickerMessageRequest extends SendMessageRequest {
    private final String type = "sticker";
    @JsonProperty("sticker_id")
    private final Integer stickerId;

    public SendStickerMessageRequest(String receiver, String senderName, String senderAvatar, Integer minApiVersion, Integer stickerId, String trackingData) {
        super(receiver, new Sender(senderName, senderAvatar), minApiVersion, trackingData);
        this.stickerId = stickerId;
    }
}
