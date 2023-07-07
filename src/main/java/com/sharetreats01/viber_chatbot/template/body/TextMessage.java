package com.sharetreats01.viber_chatbot.template.body;

public class TextMessage extends MessageBody{

    private String text;

    public TextMessage() {
        super("text");
    }
    public static class paymentsBuilder {
        private String text;
        private String productName;
        private String receiverName;
        private KeyBoardBody keyboard;
        public paymentsBuilder() {
            this.text = "%s,\n to %s,\nwhich payment method \ndo you prefer to pay?";
        }
        public paymentsBuilder receiverName(String receiver) {
            this.receiverName = receiver;
            return this;
        }
        public paymentsBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }
        public paymentsBuilder keyboard(KeyBoardBody keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public TextMessage build() {
            TextMessage message = new TextMessage();
            message.text = String.format(this.text,this.productName,this.receiverName);
            message.setKeyboard(this.keyboard);
            return message;
        }
    }
}
