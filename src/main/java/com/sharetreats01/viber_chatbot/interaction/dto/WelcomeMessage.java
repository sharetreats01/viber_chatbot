package com.sharetreats01.viber_chatbot.interaction.dto;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Sender;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class WelcomeMessage {
    private final Sender sender;
    private final String trackingData;
    private final String type;
    private final String text;
    private final String media;
    private final String thumbnail;
}
