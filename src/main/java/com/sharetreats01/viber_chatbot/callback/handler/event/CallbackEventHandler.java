package com.sharetreats01.viber_chatbot.callback.handler.event;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.CallbackRequest;
import com.sharetreats01.viber_chatbot.callback.dto.response.event.CallbackResponse;

public interface CallbackEventHandler<T extends CallbackRequest, R extends CallbackResponse> {
    Class<T> getCallbackType();

    R handleEvent(T data);
}

