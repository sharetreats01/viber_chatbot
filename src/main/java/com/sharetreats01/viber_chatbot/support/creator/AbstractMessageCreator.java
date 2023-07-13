package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractMessageCreator {
    protected final TrackingDataUtils trackingDataUtils;
    protected final ChatbotProperties chatbotProperties;

    protected abstract String createTrackingData(String trackingData, String input);

    public abstract SendMessageRequest createMessageRequest(MessageRequest request);
}