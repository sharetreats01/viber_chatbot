package com.sharetreats01.viber_chatbot.handler;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.dto.callback.response.MessageResponse;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.support.handler.message.MessageHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
        if (!StringUtils.hasText(request.getMessage().getTrackingData())) {
            return handlers.get(State.BRANDS);
        }

        if (request.getMessage().getText().equals(State.TREAT.name())) {
            return handlers.get(State.TREAT);
        }
        return handlers.get(trackingDataUtils.getState(request.getMessage().getTrackingData()));
    }
}