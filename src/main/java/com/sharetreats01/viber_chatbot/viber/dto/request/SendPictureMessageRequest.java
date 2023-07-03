package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.TrackingJSONData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SendPictureMessageRequest extends SendMessageRequest {
    private final String type = "picture";
    private final String media;
    private final String thumbnail;

    public SendPictureMessageRequest(String receiver, String senderName, String senderAvatar, Integer minApiVersion, TrackingJSONData trackingData, String media, String thumbnail) {
        super(receiver, senderName, senderAvatar, minApiVersion, trackingData);
        this.media = media;
        this.thumbnail = thumbnail;
    }
}
