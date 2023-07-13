package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.service.KeyBoardService;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import org.springframework.stereotype.Component;

@Component
public class BrandsMessageCreator extends AbstractMessageCreator {
    private final KeyBoardService keyBoardService;
    private final ChatbotProperties chatbotProperties;

    public BrandsMessageCreator(TrackingDataUtils trackingDataUtils, KeyBoardService keyBoardService, ChatbotProperties chatbotProperties) {
        super(trackingDataUtils);
        this.keyBoardService = keyBoardService;
        this.chatbotProperties = chatbotProperties;
    }

    @Override
    protected String updateTrackingData(String trackingData) {
        return trackingDataUtils.createTrackingData();
    }

    @Override
    protected SendMessageRequest createMessageRequest(String receiver, String trackingData) {
        String keyboard = keyBoardService.findBrands();
        SendTextMessageRequest textMessageRequest = new SendTextMessageRequest(receiver, chatbotProperties.getBotName(), chatbotProperties.getBotAvatar(), "choose a brand", trackingData);
        textMessageRequest.setKeyboard(keyboard);

        return textMessageRequest;
    }
}
