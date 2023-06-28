package com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.interaction.enums.Type;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Message {
    private final Type type;
    private final String text;
    private final String media;
    private final Location location;
    private final Contact contact;
    @JsonProperty("tracking_data")
    private final String trackingData;
    @JsonProperty("file_name")
    private final String fileName;
    @JsonProperty("file_size")
    private final Integer fileSize;
    private final Integer duration;
    @JsonProperty("sticker_id")
    private final Integer stickerId;

    @Getter
    @RequiredArgsConstructor
    public static class Location {
        private final String lat;
        private final String lon;
    }

    @Getter
    @RequiredArgsConstructor
    public static class Contact {
        @JsonProperty("name")
        private final String name;
        @JsonProperty("phone_number")
        private final String phoneNumber;
    }
}
