package com.sharetreats01.viber_chatbot.callback.handler.message;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.State;

public interface MessageHandler {
    State getMessageHandleType();
    void handle(MessageRequest request);
}
