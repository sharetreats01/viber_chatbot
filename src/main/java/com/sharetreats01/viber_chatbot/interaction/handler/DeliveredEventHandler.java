package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.DeliveredRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.DeliveredResponseMessage;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveredEventHandler implements CallbackEventHandler<DeliveredRequest, DeliveredResponseMessage> {
    @Override
    public Event getCallbackEvent() {
        return Event.DELIVERED;
    }

    @Override
    public DeliveredResponseMessage handleEvent(DeliveredRequest request) {
        return null;
    }
}
