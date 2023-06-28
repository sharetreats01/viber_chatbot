package com.sharetreats01.viber_chatbot.interaction.dispatcher;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.CallbackRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.CallbackResponse;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.interaction.handler.CallbackEventHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CallbackDispatcher<T extends CallbackRequest, R extends CallbackResponse> {
    private final Map<Event, CallbackEventHandler<T, R>> handlers;

    public CallbackDispatcher(final List<CallbackEventHandler<T, R>> handlers) {
        this.handlers = handlers.stream()
                .collect(Collectors.toMap(CallbackEventHandler::getCallbackEvent, Function.identity()));
    }

    public R dispatch(T data) {
        return handlers.get(data.getEvent()).handleEvent(data);
    }
}
