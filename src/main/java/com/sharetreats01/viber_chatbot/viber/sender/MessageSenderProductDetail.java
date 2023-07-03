package com.sharetreats01.viber_chatbot.viber.sender;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Status;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.TrackingJSONData;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendRichMediaMessageRequest;
import com.sharetreats01.viber_chatbot.viber.service.RichMediaService;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderProductDetail extends AbstractMessageSender implements MessageSender {
    private final RichMediaService richMediaService;

    public MessageSenderProductDetail(ViberWebClient webClient, RichMediaService richMediaService) {
        super(webClient);
        this.richMediaService = richMediaService;
    }

    @Override
    public Status getSenderKey() {
        return Status.PRODUCT_DETAIL;
    }

    @Override
    public void send(MessageRequest request) {
        super.sendResponse(request);
    }

    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest messageRequest) {
        TrackingJSONData trackingJSONData = messageRequest.getTrackingJSONData();
        return new SendRichMediaMessageRequest(messageRequest.getSender().getId(), "Viber Treats", "", 1, richMediaService.findProductDetailByProductId(messageRequest.getMessage().getText()), trackingJSONData);
    }

    @Override
    protected void setTrackingData(SendMessageRequest request) {
        request.getTrackingJSONData().setStatus(Status.PRODUCT_DETAIL);
    }
}
