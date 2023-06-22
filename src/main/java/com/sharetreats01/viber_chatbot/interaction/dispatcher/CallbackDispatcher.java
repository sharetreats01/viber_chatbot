package com.sharetreats01.viber_chatbot.interaction.dispatcher;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.interaction.handler.CallbackEventHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CallbackDispatcher {
    private final Map<Event, CallbackEventHandler> handlers;

    public CallbackDispatcher(final List<CallbackEventHandler> handlers) {
        this.handlers = handlers.stream()
                .collect(Collectors.toMap(CallbackEventHandler::getCallbackEvent, Function.identity()));
    }

    public Object dispatch(Callback callback) {
        return handlers.get(callback.getEvent()).handleEvent(callback);
    }
}
