package com.sharetreats01.viber_chatbot.viber.sender;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.TrackingJSONData;
import com.sharetreats01.viber_chatbot.interaction.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendRichMediaMessageRequest;
import com.sharetreats01.viber_chatbot.viber.service.RichMediaService;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderProducts extends AbstractMessageSender implements MessageSender {
    private final RichMediaService richMediaService;

    public MessageSenderProducts(ViberWebClient webClient, RichMediaService richMediaService) {
        super(webClient);
        this.richMediaService = richMediaService;
    }


    @Override
    public State getSenderKey() {
        return State.BRANDS;
    }

    @Override
    public void send(MessageRequest request) {
        super.sendResponse(request);
    }

    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest messageRequest) {
        String richMedia = richMediaService.findProductsByBrandName(messageRequest.getMessage().getText());
        String trackingData = TrackingDataUtils.updateState(messageRequest.getMessage().getTrackingData(), State.PRODUCTS);
        return new SendRichMediaMessageRequest(messageRequest.getSender().getId(), super.senderName, super.senderAvatar, 1, richMedia, trackingData);
    }
}
