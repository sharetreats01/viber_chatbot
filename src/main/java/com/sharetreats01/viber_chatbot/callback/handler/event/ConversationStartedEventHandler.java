package com.sharetreats01.viber_chatbot.callback.handler.event;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.ConversationStartedRequest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.User;
import com.sharetreats01.viber_chatbot.callback.dto.response.event.ConversationStartedResponse;
import com.sharetreats01.viber_chatbot.botMessage.dto.WelcomeMessageTemplateValueDto;
import com.sharetreats01.viber_chatbot.client.viber.enums.MessageType;
import com.sharetreats01.viber_chatbot.callback.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.botMessage.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class ConversationStartedEventHandler implements CallbackEventHandler<ConversationStartedRequest, ConversationStartedResponse> {
    private final ChatbotProperties properties;
    private final MessageService messageService;

    @Override
    public Class<ConversationStartedRequest> getCallbackType() {
        return ConversationStartedRequest.class;
    }

    @Override
    public ConversationStartedResponse handleEvent(ConversationStartedRequest request) {
        User user = request.getUser();
        String message = messageService.createMessage(
                new WelcomeMessageTemplateValueDto(MessageType.WELCOME, user.getLanguage(), user.getName(), properties.getBotName()));
        return ConversationStartedResponse.builder()
                .senderName(properties.getBotName())
                .senderAvatar(properties.getBotAvatar())
                .type("text")
                .text(message)
                .build();
    }
}
