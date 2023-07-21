package com.sharetreats01.viber_chatbot.botMessage.creator;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractMessageCreator {
    protected final TrackingDataUtils trackingDataUtils;

    protected abstract String createTrackingData(String trackingData, String input);

    public abstract SendMessageRequest createMessageRequest(MessageRequest request);


    protected String getReceiverId(MessageRequest request) {
        return request.getSender().getId();
    }
}