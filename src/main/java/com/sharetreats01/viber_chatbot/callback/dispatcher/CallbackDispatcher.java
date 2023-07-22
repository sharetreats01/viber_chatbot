package com.sharetreats01.viber_chatbot.callback.dispatcher;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.CallbackRequest;
import com.sharetreats01.viber_chatbot.callback.dto.response.event.CallbackResponse;
import com.sharetreats01.viber_chatbot.callback.handler.event.CallbackEventHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CallbackDispatcher<T extends CallbackRequest, R extends CallbackResponse> {
    private final Map<Class<T>, CallbackEventHandler<T, R>> handlers;

    public CallbackDispatcher(final List<CallbackEventHandler<T, R>> handlers) {
        this.handlers = handlers.stream()
                .collect(Collectors.toMap(CallbackEventHandler::getCallbackType, Function.identity()));
    }

    public R dispatch(T data) {
        return handlers.get(data.getClass()).handleEvent(data);
    }
}
