package com.sharetreats01.viber_chatbot.infra.viber.sender;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractMessageSender {
    private final ViberWebClient webClient;
    private final ChatbotProperties chatbotProperties;

    public void sendResponse(MessageRequest request) {
        createSendMessageRequest(request);
    }

    protected abstract void createSendMessageRequest(MessageRequest request);
}
