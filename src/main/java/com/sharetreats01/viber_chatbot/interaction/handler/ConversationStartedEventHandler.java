package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.WelcomeMessage;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.ConversationStarted;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Keyboard;
import com.sharetreats01.viber_chatbot.interaction.enums.ActionType;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.interaction.enums.TextSize;
import com.sharetreats01.viber_chatbot.interaction.properties.ViberProperties;
import com.sharetreats01.viber_chatbot.interaction.service.MessageService;
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
        String[] placeholders = {"name1", "name2"};
        String[] values = {conversationStarted.getUser().getName(), viberProperties.getBotName()};
        return WelcomeMessage.builder()
                .senderName("Share Treats")
                .senderAvatar(viberProperties.getBotAvatar())
                .trackingData("conversation_started")
                .type("text")
                .text(messageService.testCreateMessage(placeholders, values))
                .keyboard(Keyboard.builder()
                        .buttons(new Keyboard.Button[]{Keyboard.Button.builder()
                                .actionType(ActionType.REPLY)
                                .actionBody("reply to me")
                                .text("Key text")
                                .textSize(TextSize.REGULAR)
                                .build()})
                        .build())
                .build();
    }
}
