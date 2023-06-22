package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.ConversationStarted;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.interaction.service.MessageService;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class ConversationStartedEventHandler implements CallbackEventHandler {
    private final MessageService messageService;
    private final UserService userService;
    @Override
    public Event getCallbackEvent() {
        return Event.CONVERSATION_STARTED;
    }

    @Override
    public String handleEvent(Callback callback) {
        ConversationStarted conversationStarted = callback.buildConversationStarted();
        String[] placeholders = {"name1", "name2"};
        String[] values = {conversationStarted.getUser().getName(), "sharetreats"};
        return messageService.testCreateMessage(placeholders, values);
    }
}
