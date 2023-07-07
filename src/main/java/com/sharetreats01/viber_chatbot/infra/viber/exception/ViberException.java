package com.sharetreats01.viber_chatbot.infra.viber.exception;

import com.sharetreats01.viber_chatbot.exception.ShareTreatsException;

public class ViberException extends ShareTreatsException {
    public ViberException(String message) {
        super(message);
    }
}
