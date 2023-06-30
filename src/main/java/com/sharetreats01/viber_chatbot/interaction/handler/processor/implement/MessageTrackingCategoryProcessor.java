package com.sharetreats01.viber_chatbot.interaction.handler.processor.implement;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Tracking;
import com.sharetreats01.viber_chatbot.interaction.handler.processor.MessageTrackingProcessor;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import org.springframework.stereotype.Component;

@Component
public class MessageTrackingCategoryProcessor extends MessageResponse implements MessageTrackingProcessor {
    public MessageTrackingCategoryProcessor(ViberWebClient webClient) {
        super(webClient);
    }

    @Override
    public Tracking getTrackingType() {
        return Tracking.CATEGORY;
    }

    @Override
    public void process(MessageRequest request) {
        sendResponse(request);
    }

    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest request) {
        return null;
    }
}
