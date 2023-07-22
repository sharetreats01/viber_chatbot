package com.sharetreats01.viber_chatbot.botMessage.dto.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.botMessage.dto.body.component.Button;
import lombok.*;

import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeyBoardBody {
    @JsonProperty("Type")
    private final String type = "keyboard";

    @JsonProperty("Buttons")
    private List<Button> buttons;

}
