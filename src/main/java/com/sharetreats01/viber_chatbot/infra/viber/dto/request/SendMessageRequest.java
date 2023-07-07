package com.sharetreats01.viber_chatbot.infra.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SendMessageRequest {
    private String receiver;
    private Sender sender;
    @JsonProperty("tracking_data")
    private String trackingData;
    @JsonProperty("min_api_version")
    private Integer minApiVersion;
    @JsonRawValue
    private String keyboard;

    public SendMessageRequest(String receiver, Sender sender, Integer minApiVersion, String trackingData) {
        this.receiver = receiver;
        this.sender = sender;
        this.minApiVersion = minApiVersion;
        this.keyboard = null;
        this.trackingData = trackingData;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    @Getter
    @RequiredArgsConstructor
    @ToString
    @EqualsAndHashCode
    @AllArgsConstructor
    public static class Sender {
        private String name;
        private String avatar;
    }
}
