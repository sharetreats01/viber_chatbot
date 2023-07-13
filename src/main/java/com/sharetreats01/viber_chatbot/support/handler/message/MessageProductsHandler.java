package com.sharetreats01.viber_chatbot.support.handler.message;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.support.creator.ProductsMessageCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProductsHandler implements MessageHandler {
    private final ViberWebClient webClient;
    private final ProductsMessageCreator messageCreator;

    @Override
    public State getMessageHandleType() {
        return State.PRODUCTS;
    }

    @Override
    public void handle(MessageRequest request) {
        SendMessageRequest sendMessageRequest = messageCreator.createMessageRequest(request);
        webClient.sendMessage(sendMessageRequest);
    }
}
