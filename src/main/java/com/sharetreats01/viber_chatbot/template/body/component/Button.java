package com.sharetreats01.viber_chatbot.template.body.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Button {

    @JsonProperty("Columns")
    private int Columns;

    @JsonProperty("Rows")
    private int Rows;

    @JsonProperty("Text")
    private int Text;

    @JsonProperty("Text")
    private String TextSize;

    @JsonProperty("TextHAlign")
    private String TextHAlign;

    @JsonProperty("TextVAlign")
    private String TextVAlign;

    @JsonProperty("TextPaddings")
    private String TextPaddings;

    @JsonProperty("ActionType")
    private String ActionType;

    @JsonProperty("ActionBody")
    private String ActionBody;

    @JsonProperty("Image")
    private String Image;

    @JsonProperty("ImageScaleType")
    private String ImageScaleType;
}
