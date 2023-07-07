package com.sharetreats01.viber_chatbot.infra.viber.sender;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.service.KeyBoardService;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.user.service.UserService;
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
        return State.NEW;
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
        String trackingData = TrackingDataUtils.createTrackingData();
        SendTextMessageRequest textMessageRequest = new SendTextMessageRequest(request.getSender().getId(), chatbotProperties.getBotName(), chatbotProperties.getBotAvatar(), request.getSender().getApiVersion(), "choose a brand", trackingData);
        textMessageRequest.setKeyboard(keyboard);

        return textMessageRequest;
    }
}
