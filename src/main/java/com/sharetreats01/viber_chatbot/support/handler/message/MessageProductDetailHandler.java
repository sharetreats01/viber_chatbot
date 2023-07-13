package com.sharetreats01.viber_chatbot.support.handler.message;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.support.creator.ProductDetailMessageCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageProductDetailHandler implements MessageHandler {
    private final ViberWebClient viberWebClient;
    private final ProductDetailMessageCreator messageCreator;
    @Override
    public State getMessageHandleType() {
        return State.DETAIL;
    }

    @Override
    public void handle(MessageRequest request) {
        SendMessageRequest messageRequest = messageCreator.createMessage(request);
        viberWebClient.sendMessage(messageRequest);
    }
}
