package com.sharetreats01.viber_chatbot.botMessage.dto.body.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class ButtonFrame {
    @JsonProperty("CornerRadius")
    private int cornerRadius;
}
