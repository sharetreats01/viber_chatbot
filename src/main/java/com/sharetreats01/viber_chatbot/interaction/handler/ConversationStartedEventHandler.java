package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.WelcomeMessage;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.ConversationStarted;
import com.sharetreats01.viber_chatbot.interaction.dto.message.template.WelcomeMessageTemplateValueDto;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.interaction.enums.MessageType;
import com.sharetreats01.viber_chatbot.interaction.properties.ViberProperties;
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
    private final ViberProperties viberProperties;
    private final MessageService messageService;
    private final UserService userService;

    @Override
    public Event getCallbackEvent() {
        return Event.CONVERSATION_STARTED;
    }

    @Override
    public WelcomeMessage handleEvent(Callback callback) {
        ConversationStarted conversationStarted = callback.buildConversationStarted();
        UserEntity userEntity = userService.subscribe(conversationStarted.getUser());
        String message = messageService.createMessage(
                new WelcomeMessageTemplateValueDto(MessageType.WELCOME, userEntity.getLanguage(), userEntity.getName()));
        return WelcomeMessage.builder()
                .senderName("Share Treats")
                .senderAvatar(viberProperties.getBotAvatar())
                .trackingData("conversation_started")
                .type("text")
                .text(message)
                .build();
    }
}
