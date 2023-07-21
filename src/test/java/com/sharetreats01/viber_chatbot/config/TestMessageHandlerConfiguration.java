package com.sharetreats01.viber_chatbot.config;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.State;
import com.sharetreats01.viber_chatbot.callback.handler.message.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMessageHandlerConfiguration {
    public static Map<State, MessageHandler> getMessageHandlers() {
        MessageHandler messageBrandHandler = mock(MessageBrandsHandler.class);
        MessageHandler messageProductsHandler = mock(MessageProductsHandler.class);
        MessageHandler messageProductDetailHandler = mock(MessageProductDetailHandler.class);
        MessageHandler messageTreatHandler = mock(MessageTreatHandler.class);

        when(messageBrandHandler.getMessageHandleType()).thenReturn(State.BRANDS);
        when(messageProductsHandler.getMessageHandleType()).thenReturn(State.PRODUCTS);
        when(messageProductDetailHandler.getMessageHandleType()).thenReturn(State.DETAIL);
        when(messageTreatHandler.getMessageHandleType()).thenReturn(State.TREAT);

        List<MessageHandler> handlers = Arrays.asList(messageBrandHandler, messageProductsHandler, messageProductDetailHandler, messageTreatHandler);

        return handlers.stream().collect(Collectors.toMap(MessageHandler::getMessageHandleType, Function.identity()));
    }

}