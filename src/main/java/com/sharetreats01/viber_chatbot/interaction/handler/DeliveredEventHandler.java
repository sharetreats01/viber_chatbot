package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveredEventHandler implements CallbackEventHandler {
    @Override
    public Event getCallbackEvent() {
        return Event.DELIVERED;
    }

    @Override
    public Void handleEvent(Callback callback) {
        return null;
    }
}
