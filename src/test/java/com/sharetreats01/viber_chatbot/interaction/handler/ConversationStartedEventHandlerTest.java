package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.interaction.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.openMocks;

class ConversationStartedEventHandlerTest {
    @Mock
    private ChatbotProperties properties;

    @Mock
    private MessageService messageService;

    @InjectMocks
    private ConversationStartedEventHandler conversationStartedEventHandler;


    @BeforeEach
    public void init() {
        openMocks(this);
    }
}