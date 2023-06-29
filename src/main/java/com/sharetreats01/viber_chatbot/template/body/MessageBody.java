package com.sharetreats01.viber_chatbot.template.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.template.body.component.Sender;
import lombok.Setter;

@Setter
public class MessageBody {

    private String receiver;
    private final Sender sender;
    private String trackingData;
    private int minApiVersion;

    @JsonProperty("Type")
    private String Type;
    private String text;

    private KeyBoardComponent keyboard;

    MessageBody(Sender sender) {
        this.sender = sender;
    }
}
