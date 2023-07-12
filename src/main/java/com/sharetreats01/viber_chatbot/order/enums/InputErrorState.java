package com.sharetreats01.viber_chatbot.order.enums;

public enum InputErrorState {
    EMPTY_INPUT("you didn't text important info \n text again please"),
    INVALID_PHONE("phone number again"),
    INVALID_EMAIL("you text invalid email address\n put this again"),
    INVALID_CODE("your promo code is not available"),
    NO_MESSAGE("you did not put message");
    private String message;

    InputErrorState (String value) {
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}

