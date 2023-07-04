package com.sharetreats01.viber_chatbot.viber.sender;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class AbstractMessageSender {
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
