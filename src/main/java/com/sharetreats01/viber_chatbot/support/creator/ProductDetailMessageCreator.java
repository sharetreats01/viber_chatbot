package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.service.KeyBoardService;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailMessageCreator extends AbstractMessageCreator {

    private final KeyBoardService keyBoardService;

    public ProductDetailMessageCreator(TrackingDataUtils trackingDataUtils, ChatbotProperties chatbotProperties, KeyBoardService keyBoardService) {
        super(trackingDataUtils, chatbotProperties);
        this.keyBoardService = keyBoardService;
    }

    @Override
    protected String createTrackingData(String trackingData, String input) {
        return trackingDataUtils.updateData(trackingData, input);
    }

    public SendMessageRequest createMessageRequest(MessageRequest request) {
        String receiver = request.getSender().getId();
        String trackingData = createTrackingData(request.getMessage().getTrackingData(), request.getMessage().getText());
        String keyboard = keyBoardService.findBrands();
        SendTextMessageRequest textMessageRequest = new SendTextMessageRequest(receiver, chatbotProperties.getBotName(), chatbotProperties.getBotAvatar(), trackingData);
        textMessageRequest.setKeyboard(keyboard);

        return textMessageRequest;
    }
}
