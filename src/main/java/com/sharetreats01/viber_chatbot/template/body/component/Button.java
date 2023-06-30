package com.sharetreats01.viber_chatbot.template.body.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Button {
    @JsonProperty("Columns")
    private int columns;

    @JsonProperty("Rows")
    private int rows;

    @JsonProperty("Text")
    private String text;

    @JsonProperty("TextSize")
    private String textSize;

    @JsonProperty("TextHAlign")
    private String textHAlign;

    @JsonProperty("TextVAlign")
    private String textVAlign;

    @JsonProperty("TextPaddings")
    private int[] textPaddings;

    @JsonProperty("ActionType")
    private String actionType;

    @JsonProperty("ActionBody")
    private String actionBody;

    @JsonProperty("Image")
    private String image;

    @JsonProperty("ImageScaleType")
    private String imageScaleType;

    public Button () {
        this.columns = 2;
        this.rows = 2;
        this.text = "<font color=\"#494E67\">%s</font>";
        this.textSize = "regular";
        this.textHAlign = "center";
        this.textVAlign = "bottom";
        this.textPaddings = new int[] {12, 12, 6, 12};
        this.actionType = "reply";
        this.actionBody = "";
        this.image = "";
        this.imageScaleType = "fit";
    }

    public static class builder {
        private String text;
        private String actionBody;
        private String image;
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
        public builder image(String imageUrl){
            this.image = imageUrl;
            return this;
        }

        public Button build() {
            Button button = new Button();
            button.text = String.format(button.text, this.text);
            button.actionBody = this.actionBody;
            button.image = this.image;
            return button;
        }

    }

}
