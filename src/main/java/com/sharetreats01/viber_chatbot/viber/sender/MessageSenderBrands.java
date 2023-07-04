package com.sharetreats01.viber_chatbot.viber.sender;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.interaction.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.viber.service.KeyBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSenderBrands extends AbstractMessageSender implements MessageSender {
    private final UserService userService;
    private final KeyBoardService keyBoardService;

    public MessageSenderBrands(ViberWebClient webClient, ChatbotProperties chatbotProperties, UserService userService, KeyBoardService keyBoardService) {
        super(webClient, chatbotProperties);
        this.userService = userService;
        this.keyBoardService = keyBoardService;
    }

    @Override
    public State getSenderKey() {
        return null;
    }

    @Override
    public void send(MessageRequest request) {
        userService.subscribe(request.getSender().getId());
        super.sendResponse(request);
    }


    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest request) {
        log.info("{}", request);
        String keyboard = keyBoardService.findBrands();
        SendTextMessageRequest textMessageRequest = new SendTextMessageRequest(request.getSender().getId(), chatbotProperties.getBotName(), chatbotProperties.getBotAvatar(), request.getSender().getApiVersion(), "Thank you for Subscribe!");
        textMessageRequest.setKeyboard(keyboard);

        return textMessageRequest;
    }
}
