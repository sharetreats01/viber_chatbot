package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Sender {
    private String name;
    private String avatar;
}
