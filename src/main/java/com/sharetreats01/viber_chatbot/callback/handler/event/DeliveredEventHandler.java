package com.sharetreats01.viber_chatbot.callback.handler.event;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.DeliveredRequest;
import com.sharetreats01.viber_chatbot.callback.dto.response.event.DeliveredResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveredEventHandler implements CallbackEventHandler<DeliveredRequest, DeliveredResponseMessage> {
    @Override
    public Class<DeliveredRequest> getCallbackType() {
        return DeliveredRequest.class;
    }

    @Override
    public DeliveredResponseMessage handleEvent(DeliveredRequest request) {
        return null;
    }
}
