package com.sharetreats01.viber_chatbot.support.enums;

public enum TreatInputValidType {
    VALID_INPUT,
    WRONG_INPUT("You text invalid form\nPlease try again"),
    EXCEED_NAME_LENGTH("name over 7 letter\nPlease try again"),
    INVALID_PHONE("Phone number is invalid\nPlease try again"),
    INVALID_EMAIL("Email is invalid\nPlease try again"),
    WRONG_MESSAGE("Message is invalid text\nPlease Try again"),
    INVALID_PROMO_CODE("You put invalid promotion code");

    private String text;
    TreatInputValidType(String text) {
        this.text = text;
    }
    TreatInputValidType() {}

    public String getText() {
        return text;
    }

    public static String getMessageFromName(String name) {
        for (TreatInputValidType inputValidType : values()) {
            if (inputValidType.name().equals(name))
                return inputValidType.getText();
        }
        return "";
    }
}