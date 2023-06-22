package com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {
    private final String id;
    private final String name;
    private final String avatar;
    private final String country;
    private final String language;
    private final int apiVersion;
}
