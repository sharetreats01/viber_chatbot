package com.sharetreats01.viber_chatbot.hyelin.template.body.parameter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class Button {
    /**
     * {
     *             "Columns": 2,
     *             "Rows": 2,
     *             "Text": "<br><font color=\"#494E67\"><b>MORE</b></font>",
     *             "TextSize": "large",
     *             "TextHAlign": "center",
     *             "TextVAlign": "bottom",
     *             "ActionType": "reply",
     *             "ActionBody": "More",
     *             "BgColor": "#a8aaba",
     *             "Image": "https://1000logos.net/wp-content/uploads/2017/03/McDonalds-logo.png"
     *         }
     */
    @JsonProperty("Columns")
    private int Columns;
    @JsonProperty("Rows")
    private int Rows;
    @JsonProperty("Text")
    private String Text = "<br><font color=\"#494E67\"><b>%s</b></font>";



}
