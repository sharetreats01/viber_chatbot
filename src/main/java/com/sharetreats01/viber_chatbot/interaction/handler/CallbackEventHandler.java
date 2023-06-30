package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.CallbackRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.CallbackResponse;

public interface CallbackEventHandler<T extends CallbackRequest, R extends CallbackResponse> {
    Class<T> getCallbackType();

    R handleEvent(T data);
}

