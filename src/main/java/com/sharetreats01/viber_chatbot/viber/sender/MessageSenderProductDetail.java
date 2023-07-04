package com.sharetreats01.viber_chatbot.viber.sender;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.interaction.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.interaction.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendRichMediaMessageRequest;
import com.sharetreats01.viber_chatbot.viber.service.RichMediaService;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderProductDetail extends AbstractMessageSender implements MessageSender {
    private final RichMediaService richMediaService;

    public MessageSenderProductDetail(ViberWebClient webClient, ChatbotProperties chatbotProperties, RichMediaService richMediaService) {
        super(webClient, chatbotProperties);
        this.richMediaService = richMediaService;
    }

    @Override
    public State getSenderKey() {
        return State.PRODUCTS;
    }

    @Override
    public void send(MessageRequest request) {
        super.sendResponse(request);
    }

    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest messageRequest) {
        String richMedia = richMediaService.findProductDetailByProductId(messageRequest.getMessage().getText());
        String trackingData = TrackingDataUtils.updateState(messageRequest.getMessage().getTrackingData(), State.PRODUCT_DETAIL, messageRequest.getMessage().getText());
        return new SendRichMediaMessageRequest(messageRequest.getSender().getId(), chatbotProperties.getBotName(), chatbotProperties.getBotAvatar(), 1, richMedia, trackingData);
    }
}
