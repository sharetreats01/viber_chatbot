package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.CallbackRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.CallbackResponse;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;

public interface CallbackEventHandler<T extends CallbackRequest, R extends CallbackResponse> {
    Event getCallbackEvent();

    R handleEvent(T data);
}

