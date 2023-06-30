package com.sharetreats01.viber_chatbot.template.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.template.body.component.Sender;
import lombok.Builder;
import lombok.Setter;

@Setter
public class MessageBody {

    private String receiver;
    private Sender sender;
    private String trackingData;
    private int minApiVersion;

    @JsonProperty("Type")
    private String type;

    private String text;

    private KeyBoardBody keyboard;

    MessageBody(Sender sender) {
        this.sender = sender;
        this.minApiVersion = 6;
    }

}
