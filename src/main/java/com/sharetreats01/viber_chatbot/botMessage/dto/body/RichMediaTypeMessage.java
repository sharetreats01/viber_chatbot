package com.sharetreats01.viber_chatbot.botMessage.dto.body;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.botMessage.dto.body.component.RichButton;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RichMediaTypeMessage extends MessageBody{

    @JsonProperty("Type")
    private String type;
    @JsonProperty("ButtonsGroupColumns")
    private int buttonsGroupColumns;

    @JsonProperty("ButtonsGroupRows")
    private int buttonsGroupRows;

    @JsonProperty("BgColor")
    private String bgColor;

    @JsonProperty("Buttons")
    private List<RichButton> buttons;

    public RichMediaTypeMessage() {
        super("rich_media");
        this.type = "rich_media";
        this.bgColor = "#F9FBFD";
        this.buttonsGroupColumns = 6;
        this.buttonsGroupRows = 2;
    }

}
