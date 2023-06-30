package com.sharetreats01.viber_chatbot.interaction.handler.processor.implement;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class MessageResponse {
    private final ViberWebClient webClient;
    void sendResponse(MessageRequest request) {
        webClient.sendMessage(createSendMessageRequest(request));
    }

    protected abstract SendMessageRequest createSendMessageRequest(MessageRequest request);
}
