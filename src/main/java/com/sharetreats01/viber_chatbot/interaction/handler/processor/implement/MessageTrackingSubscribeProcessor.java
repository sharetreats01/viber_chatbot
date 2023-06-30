package com.sharetreats01.viber_chatbot.interaction.handler.processor.implement;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Tracking;
import com.sharetreats01.viber_chatbot.interaction.handler.processor.MessageTrackingProcessor;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import org.springframework.stereotype.Component;

@Component
public class MessageTrackingSubscribeProcessor extends MessageResponse implements MessageTrackingProcessor {
    private final UserService userService;

    public MessageTrackingSubscribeProcessor(ViberWebClient webClient, UserService userService) {
        super(webClient);
        this.userService = userService;
    }

    @Override
    public Tracking getTrackingType() {
        return Tracking.SUBSCRIBE;
    }

    @Override
    public void process(MessageRequest request) {
        userService.subscribe(request.getSender().getId());
        super.sendResponse(request);
    }


    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest request) {
        return null;
    }
}
