package com.sharetreats01.viber_chatbot.callback.handler.message;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.State;
import com.sharetreats01.viber_chatbot.client.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.creator.BrandsMessageCreator;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageBrandsHandler implements MessageHandler {
    private final ViberWebClient webClient;
    private final UserService userService;
    private final BrandsMessageCreator messageCreator;

    @Override
    public State getMessageHandleType() {
        return State.BRANDS;
    }

    @Override
    public void handle(MessageRequest request) {
        userService.subscribe(request.getSender().getId());
        SendMessageRequest sendMessageRequest = messageCreator.createMessageRequest(request);
        webClient.sendMessage(sendMessageRequest);
    }
}
