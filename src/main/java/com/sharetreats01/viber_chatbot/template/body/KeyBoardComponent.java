package com.sharetreats01.viber_chatbot.template.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.template.body.component.Button;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class KeyBoardComponent {

    @JsonProperty("Type")
    private String Type;

    @JsonProperty("Buttons")
    private List<Button> Buttons;

    KeyBoardComponent() {
        this.Type = "keyboard";
    }

}
