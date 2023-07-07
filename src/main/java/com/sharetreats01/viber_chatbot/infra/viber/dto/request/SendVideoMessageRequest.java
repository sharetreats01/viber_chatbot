package com.sharetreats01.viber_chatbot.infra.viber.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendVideoMessageRequest extends SendMessageRequest {
    private final String type = "video";
    private final String media;
    private final String thumbnail;
    private final Integer size;
    private final Integer duration;

    public SendVideoMessageRequest(String receiver, String senderName, String senderAvatar, Integer minApiVersion, String trackingData, String media, String thumbnail, Integer size, Integer duration) {
        super(receiver, new Sender(senderName, senderAvatar), minApiVersion, trackingData);
        this.media = media;
        this.thumbnail = thumbnail;
        this.size = size;
        this.duration = duration;
    }
}
