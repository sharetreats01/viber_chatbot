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

    @JsonProperty("BgColor")
    private String bgColor;

    @JsonProperty("Frame")
    private ButtonFrame frame;

    public Button () {
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
            button.columns = 2;
            button.rows = 2;
            button.text = "<font color=\"#494E67\">%s</font>";
            button.textSize = "regular";
            button.textHAlign = "center";
            button.textVAlign = "bottom";
            button.textPaddings = new int[] {12, 12, 6, 12};
            button.actionType = "reply";
            button.imageScaleType = "fit";
            
            button.text = String.format(button.text, this.text);
            button.actionBody = this.actionBody;
            button.image = this.image;
            return button;
        }

    }

    public static class paymentBuilder {
        private Long payementId;
        private String originPrice;
        private String discountedPrice;
        private String name;
        private boolean discounted;

        public paymentBuilder payementId(Long paymentId) {
            this.payementId = paymentId;
            return this;
        }
        public paymentBuilder originPrice(String originPrice) {
            this.originPrice = originPrice;
            return this;
        }

        public paymentBuilder discountedPrice(String discountedPrice) {
            this.discountedPrice = discountedPrice;
            return this;
        }

        public paymentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public paymentBuilder discounted(boolean discounted) {
            this.discounted = discounted;
            return this;
        }

        public Button build() {
            Button button = new Button();
            button.columns = 3;
            button.rows = 2;
            button.bgColor = "#7360f2";
            button.actionType = "reply";
            button.text = "";
            button.textSize = "large";
            button.textHAlign = "center";
            button.textVAlign = "middle";
            button.frame = new ButtonFrame();
            button.frame.setCornerRadius(10);

            button.actionBody = String.format("PAYMENT_%s",this.payementId.toString());

            if (this.discounted) {
                button.text = String.format(
                    "<font color=\"#ffffff\">%s</font>\n"
                    +"<font color=\"#EE4B2B\"><s>%s</s></font> "
                    + "<font color=\"#00000\">%s</font>"
                , this.name, this.originPrice, this.discountedPrice);
            }else {
                button.text = String.format(
                    "<font color=\"#ffffff\">%s</font>\n"
                    +"<font color=\"#00000\">%s</font>"
                    ,this.name,this.originPrice);
            }

            return button;
        }
    }

}
