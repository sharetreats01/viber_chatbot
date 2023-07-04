package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendRichMediaMessageRequest extends SendMessageRequest {
    private final String type = "rich_media";
    @JsonProperty("rich_media")
    private final String richMedia;

    public SendRichMediaMessageRequest(String receiver, String senderName, String senderAvatar, Integer minApiVersion, String richMedia, String trackingData) {
        super(receiver, senderName, senderAvatar, minApiVersion, trackingData);
        this.richMedia = richMedia;
    }
}
