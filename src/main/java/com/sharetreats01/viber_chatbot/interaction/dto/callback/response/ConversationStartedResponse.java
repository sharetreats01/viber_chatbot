package com.sharetreats01.viber_chatbot.interaction.dto.callback.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.TrackingJSONData;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.property.Sender;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConversationStartedResponse extends CallbackResponse {
    private final Sender sender;
    @JsonProperty("tracking_data")
    private final String trackingData;
    private final String type;
    private final String text;
    private final String media;
    private final String thumbnail;

    @Builder
    public ConversationStartedResponse(String senderName, String senderAvatar, String trackingData, String type, String text, String media, String thumbnail) {
        this.sender = new Sender(senderName, senderAvatar);
        this.trackingData = trackingData;
        this.type = type;
        this.text = text;
        this.media = media;
        this.thumbnail = thumbnail;
    }
}
