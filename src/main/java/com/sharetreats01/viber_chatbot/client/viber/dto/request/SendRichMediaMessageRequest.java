package com.sharetreats01.viber_chatbot.client.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendRichMediaMessageRequest extends SendMessageRequest {
    private final String type = "rich_media";

    @JsonProperty("rich_media")
    @JsonRawValue
    private final String richMedia;

    public SendRichMediaMessageRequest(String receiver, Integer minApiVersion, String richMedia, String trackingData) {
        super(receiver, null, minApiVersion, trackingData);
        this.richMedia = richMedia;
    }
}
