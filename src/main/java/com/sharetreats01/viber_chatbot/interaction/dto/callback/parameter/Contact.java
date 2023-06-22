package com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Contact {
    private final String name;
    private final String phoneNumber;
}
