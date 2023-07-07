package com.sharetreats01.viber_chatbot.exception;

import com.sharetreats01.viber_chatbot.exception.ShareTreatsException;

public class UserNotFoundException extends ShareTreatsException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
