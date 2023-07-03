package com.sharetreats01.viber_chatbot.template.body.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RichButton {
    @JsonProperty("Columns")
    private int columns;

    @JsonProperty("Rows")
    private int rows;

    @JsonProperty("BgColor")
    private String bgColor;

    @JsonProperty("Text")
    private String text;

    @JsonProperty("TextSize")
    private String textSize;

    @JsonProperty("TextHAlign")
    private String textHAlign;

    @JsonProperty("TextVAlign")
    private String textVAlign;

    @JsonProperty("ActionType")
    private String actionType;

    @JsonProperty("ActionBody")
    private String actionBody;

    public RichButton() {
        this.columns = 6;
        this.rows = 1;
        this.bgColor = "#7765F2";
        this.text = "<font color=\"#F9FBFD\">%s</font>";
        this.textSize = "large";
        this.textHAlign = "middle";
        this.textVAlign = "middle";
        this.actionType = "open-url";
        this.actionBody = "";
    }

    public static class builder {
        private String text;
        private String actionBody;
        public builder() {

        }
        public builder text(String text) {
            this.text = text;
            return this;
        }
        public builder actionBody(String actionBody) {
            this.actionBody = actionBody;
            return this;
        }

        public RichButton build() {
            RichButton button = new RichButton();
            button.text = String.format(button.text, this.text);
            button.actionBody = this.actionBody;
            return button;
        }

    }

}
