package com.sharetreats01.viber_chatbot.viber.dto.request;

import lombok.Getter;

@Getter
public class SendVideoMessageRequest extends SendMessageRequest {
    private final String type = "video";
    private final String media;
    private final String thumbnail;
    private final Integer size;
    private final Integer duration;

    public SendVideoMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, String media, String thumbnail, Integer size, Integer duration) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
        this.media = media;
        this.thumbnail = thumbnail;
        this.size = size;
        this.duration = duration;
    }
}
