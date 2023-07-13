package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractMessageCreator {
    protected final TrackingDataUtils trackingDataUtils;

    public SendMessageRequest createMessage(MessageRequest request) {
        String trackingData = updateTrackingData(request.getMessage().getTrackingData());

        return createMessageRequest(request.getSender().getId(), trackingData);
    }

    public SendMessageRequest createMessage(String receiver, String trackingData) {
        return createMessageRequest(receiver, trackingData);
    }


    protected abstract String updateTrackingData(String trackingData);
    protected abstract SendMessageRequest createMessageRequest(String receiver, String trackingData);
}
