package com.sharetreats01.viber_chatbot.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.TrackingJSONData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class SendMessageRequest {
    private final String receiver;
    private final Sender sender;
    @JsonProperty("tracking_data")
    private TrackingJSONData trackingJSONData;
    @JsonProperty("min_api_version")
    private final Integer minApiVersion;
    @JsonRawValue
    private String keyboard;

    public SendMessageRequest(String receiver, String senderName, String senderAvatar, Integer minApiVersion, TrackingJSONData trackingData) {
        this.receiver = receiver;
        this.sender = new Sender(senderName, senderAvatar);
        this.minApiVersion = minApiVersion;
        this.keyboard = null;
        this.trackingJSONData = trackingData;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    @Getter
    @RequiredArgsConstructor
    @ToString
    @EqualsAndHashCode
    private static class Sender {
        private final String name;
        private final String avatar;
    }
}
