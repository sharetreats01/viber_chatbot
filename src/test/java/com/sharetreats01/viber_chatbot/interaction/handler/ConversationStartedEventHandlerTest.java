package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.CallbackRequestFactory;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.UserFactory;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.ConversationStartedRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.ConversationStartedResponse;
import com.sharetreats01.viber_chatbot.interaction.dto.message.template.WelcomeMessageTemplateValueDto;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.interaction.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.interaction.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
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

    @Test
    public void 대화시작_이벤트_핸들러_테스트() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConversationStartedRequest request =
                CallbackRequestFactory.createConversationRequest(
                        1457764197627L, 4912661846655238145L, "open", "context_information",
                        UserFactory.createUserDto("01234567890A=", "John McClane", "http://avatar.example.com", "UK", "en", 1),
                        false);

        when(messageService.createMessage(any(WelcomeMessageTemplateValueDto.class))).thenReturn("Hello! John McClane. I'm Share Treats bot.");
        when(properties.getBotName()).thenReturn("Share Treats");
        when(properties.getBotAvatar()).thenReturn("http://avatar.example.com");

        ConversationStartedResponse expectedTarget = ConversationStartedResponse.builder()
                .senderName("Share Treats")
                .senderAvatar("http://avatar.example.com")
                .trackingData("conversation_started")
                .type("text")
                .text("Hello! John McClane. I'm Share Treats bot.")
                .build();

        ConversationStartedResponse result = conversationStartedEventHandler.handleEvent(request);

        verify(messageService, times(1)).createMessage(any());
        verify(properties, times(1)).getBotAvatar();
        verify(properties, times(2)).getBotName();

        assertEquals(expectedTarget, result);
    }
}