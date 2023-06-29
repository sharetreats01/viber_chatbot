package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SendFileMessageRequest extends SendMessageRequest {
    private final String type = "file";
    private final String media;
    private final Integer size;
    @JsonProperty("file_name")
    private final String fileName;

    public SendFileMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, String media, Integer size, String fileName) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
        this.media = media;
        this.size = size;
        this.fileName = fileName;
    }
}
