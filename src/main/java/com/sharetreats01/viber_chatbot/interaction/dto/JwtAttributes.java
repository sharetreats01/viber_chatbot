package com.sharetreats01.viber_chatbot.interaction.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JwtAttributes {
    private final String id;
    private final String name;
    private final String country;
    private final String language;
}
