package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.TrackingJSONData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendFileMessageRequest extends SendMessageRequest {
    private final String type = "file";
    private final String media;
    private final Integer size;
    @JsonProperty("file_name")
    private final String fileName;

    public SendFileMessageRequest(String receiver, String senderName, String senderAvatar, Integer minApiVersion, String media, Integer size, String fileName, String trackingData) {
        super(receiver, senderName, senderAvatar, minApiVersion, trackingData);
        this.media = media;
        this.size = size;
        this.fileName = fileName;
    }
}
