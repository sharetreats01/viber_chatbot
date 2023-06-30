package com.sharetreats01.viber_chatbot.interaction.handler.processor;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Tracking;

public interface MessageTrackingProcessor {
    Tracking getTrackingType();
    void process(MessageRequest request);
}
