package com.sharetreats01.viber_chatbot.callback.handler.message;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.State;
import com.sharetreats01.viber_chatbot.client.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.creator.ProductDetailMessageCreator;
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
        SendMessageRequest messageRequest = messageCreator.createMessageRequest(request);
        viberWebClient.sendMessage(messageRequest);
    }
}
