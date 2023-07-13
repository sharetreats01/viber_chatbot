package com.sharetreats01.viber_chatbot.handler;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.dto.callback.response.MessageResponse;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.support.handler.message.MessageHandler;

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
        log.info("{} {}", trackingData, input);
        return handlers.get(trackingDataUtils.getNextState(trackingData, input));
    }
}