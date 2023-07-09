package com.sharetreats01.viber_chatbot.infra.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.property.Keyboard;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendProductRichMediaMessageRequest extends SendMessageRequest{
    private final String type = "rich_media";

    @JsonProperty("rich_media")
    private final Keyboard richMedia;

    public SendProductRichMediaMessageRequest(String receiver, Integer minApiVersion, Keyboard richMedia, String trackingData) {
        super(receiver, null, minApiVersion, trackingData);
        this.richMedia = richMedia;
    }
}
