package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendRichMediaMessageRequest extends SendMessageRequest {
    private final String type = "rich_media";

    @JsonProperty("rich_media")
    @JsonRawValue
    private final String richMedia;

    public SendRichMediaMessageRequest(String receiver, Integer minApiVersion, String richMedia, String trackingData) {
        super(receiver, null, null, minApiVersion, trackingData);
        this.richMedia = richMedia;
    }
}
