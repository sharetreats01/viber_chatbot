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

    private KeyBoardBody keyboard;

    @JsonProperty("Type")
    private String type;

    MessageBody(String type) {
        this.sender = new Sender();
        this.minApiVersion = 6;
        this.type = type;
    }

    MessageBody(Sender sender) {
        this.sender = sender;
        this.minApiVersion = 6;
    }

}
