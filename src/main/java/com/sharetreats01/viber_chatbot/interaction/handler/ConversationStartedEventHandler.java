package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.WelcomeMessage;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.ConversationStarted;
import com.sharetreats01.viber_chatbot.interaction.dto.message.template.WelcomeMessageTemplateValueDto;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.interaction.enums.MessageType;
import com.sharetreats01.viber_chatbot.interaction.properties.InteractionProperties;
import com.sharetreats01.viber_chatbot.interaction.service.MessageService;
import com.sharetreats01.viber_chatbot.user.entity.UserEntity;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class ConversationStartedEventHandler implements CallbackEventHandler {
    private final InteractionProperties interactionProperties;
    private final MessageService messageService;

    @Override
    public Event getCallbackEvent() {
        return Event.CONVERSATION_STARTED;
    }

    @Override
    public WelcomeMessage handleEvent(Callback callback) {
        ConversationStartedDto conversationStartedDto = callback.buildConversationStarted();
        String message = messageService.createMessage(
                new WelcomeMessageTemplateValueDto(MessageType.WELCOME, userEntity.getLanguage(), userEntity.getName(), interactionProperties.getBot_name()));
                new WelcomeMessageTemplateValueDto(MessageType.WELCOME, conversationStartedDto.getUserDto().getLanguage(), conversationStartedDto.getUserDto().getName()));
        return WelcomeMessage.builder()
                .senderName(viberProperties.getBotName())
                .senderAvatar(viberProperties.getBotAvatar())
                .trackingData("conversation_started")
                .type("text")
                .text(message)
                .build();
    }
}
