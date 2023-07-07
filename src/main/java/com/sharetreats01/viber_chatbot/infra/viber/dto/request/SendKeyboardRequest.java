package com.sharetreats01.viber_chatbot.infra.viber.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.property.Keyboard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SendKeyboardRequest {
    @JsonProperty("Type")
    private final java.lang.String type = "keyboard";

    @JsonProperty("Buttons")
    private final Keyboard.Button[] buttons;
}
