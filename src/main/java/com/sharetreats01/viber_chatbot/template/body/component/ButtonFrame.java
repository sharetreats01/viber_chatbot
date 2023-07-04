package com.sharetreats01.viber_chatbot.template.body.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class ButtonFrame {
    @JsonProperty("CornerRadius")
    private int cornerRadius;
}
