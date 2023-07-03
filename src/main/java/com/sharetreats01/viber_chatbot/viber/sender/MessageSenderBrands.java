package com.sharetreats01.viber_chatbot.viber.sender;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Status;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendRichMediaMessageRequest;
import com.sharetreats01.viber_chatbot.viber.service.KeyBoardService;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderBrands extends AbstractMessageSender implements MessageSender {
    private final KeyBoardService keyBoardService;
    public MessageSenderBrands(ViberWebClient webClient, KeyBoardService keyBoardService) {
        super(webClient);
        this.keyBoardService = keyBoardService;
    }

    @Override
    public Status getSenderKey() {
        return Status.NEW;
    }

    @Override
    public void send(MessageRequest request) {
        super.sendResponse(request);
    }

    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest request) {
        String keyboard = keyBoardService.findBrands();
        return new SendRichMediaMessageRequest(request.getSender().getId(), super.senderName, super.senderAvatar, request.getSender().getApiVersion(), keyboard, request.getTrackingJSONData());
    }

    @Override
    protected void setTrackingData(SendMessageRequest request) {
        request.getTrackingJSONData().setStatus(Status.BRANDS);
    }
}
