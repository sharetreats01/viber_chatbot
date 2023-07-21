package com.sharetreats01.viber_chatbot.callback.handler.message;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.client.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.callback.properties.ChatbotProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class AbstractMessageHandler {
    private final ViberWebClient webClient;
    protected final ChatbotProperties chatbotProperties;
    protected final String senderName = "Viber Treats";
    protected final String senderAvatar = "";

    void sendResponse(MessageRequest messageRequest) {
        SendMessageRequest sendMessageRequest = createSendMessageRequest(messageRequest);
        webClient.sendMessage(sendMessageRequest);
    }

    protected abstract SendMessageRequest createSendMessageRequest(MessageRequest request);
}
