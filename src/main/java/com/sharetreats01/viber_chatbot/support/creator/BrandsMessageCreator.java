package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.service.KeyBoardService;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.service.MessageService;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import org.springframework.stereotype.Component;

@Component
public class BrandsMessageCreator extends AbstractMessageCreator {
    private final KeyBoardService keyBoardService;
    private final MessageService messageService;
    private final ChatbotProperties chatbotProperties;

    public BrandsMessageCreator(TrackingDataUtils trackingDataUtils, KeyBoardService keyBoardService, MessageService messageService, ChatbotProperties chatbotProperties) {
        super(trackingDataUtils);
        this.keyBoardService = keyBoardService;
        this.messageService = messageService;
        this.chatbotProperties = chatbotProperties;
    }

    @Override
    protected String createTrackingData(String trackingData, String input) {
        return trackingDataUtils.createTrackingData();
    }

    @Override
    public SendMessageRequest createMessageRequest(MessageRequest request) {
        String receiver = getReceiverId(request);
        String trackingData = createTrackingData(request.getMessage().getTrackingData(), request.getMessage().getText());
        SendTextMessageRequest textMessageRequest = new SendTextMessageRequest(receiver, chatbotProperties.getBotName(), chatbotProperties.getBotAvatar(), messageService.findBrandsMessage(), trackingData);
        textMessageRequest.setKeyboard(keyBoardService.findBrands());

        return textMessageRequest;
    }
}
