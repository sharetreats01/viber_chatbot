package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;

public interface CallbackEventHandler {
    Event getCallbackEvent();
    Object handleEvent(Callback dto);
}
