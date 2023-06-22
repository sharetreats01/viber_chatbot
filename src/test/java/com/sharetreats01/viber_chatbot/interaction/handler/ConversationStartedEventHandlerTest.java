package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.ConversationStarted;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.User;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.interaction.properties.ViberProperties;
import com.sharetreats01.viber_chatbot.interaction.service.MessageService;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.openMocks;

class ConversationStartedEventHandlerTest {
    @Mock
    private ViberProperties viberProperties;

    @Mock
    private MessageService messageService;

    @Mock
    private UserService userService;

    @InjectMocks
    private ConversationStartedEventHandler conversationStartedEventHandler;


    @BeforeEach
    public void init() {
        openMocks(this);
    }
    @Test
    public void testEventHandle() {
    }

}