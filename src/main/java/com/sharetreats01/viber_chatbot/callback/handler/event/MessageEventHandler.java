package com.sharetreats01.viber_chatbot.callback.handler.event;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.State;
import com.sharetreats01.viber_chatbot.callback.dto.response.event.MessageResponse;
import com.sharetreats01.viber_chatbot.callback.handler.message.MessageHandler;
import com.sharetreats01.viber_chatbot.botMessage.util.TrackingDataUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageEventHandler implements CallbackEventHandler<MessageRequest, MessageResponse> {
    private final Map<State, MessageHandler> handlers;
    private final TrackingDataUtils trackingDataUtils;

    @Override
    public Class<MessageRequest> getCallbackType() {
        return MessageRequest.class;
    }

    @Override
    public MessageResponse handleEvent(MessageRequest request) {
        MessageHandler messageHandler = getHandler(request);
        messageHandler.handle(request);
        return null;
    }

    private MessageHandler getHandler(MessageRequest request) {
        String trackingData = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();
        return handlers.get(trackingDataUtils.getNextState(trackingData, input));
    }
}