package com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Location {
    private final String lat;
    private final String lon;
}
