package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.DeliveredRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.DeliveredResponseMessage;
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
