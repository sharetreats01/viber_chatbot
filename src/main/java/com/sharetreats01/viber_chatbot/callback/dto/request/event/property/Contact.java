package com.sharetreats01.viber_chatbot.callback.dto.request.event.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Contact {
    @JsonProperty("name")
    private final String name;
    @JsonProperty("phone_number")
    private final String phoneNumber;
}
