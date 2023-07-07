package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.handler.MessageEventHandler;
import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.sender.MessageSenderBrands;
import com.sharetreats01.viber_chatbot.infra.viber.service.KeyBoardService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

class MessageEventHandlerTest extends AbstractMockTest {
    @Mock
    private UserService userService;
    @Mock
    private KeyBoardService keyBoardService;
    @Mock
    private ViberWebClient viberWebClient;

    @Mock
    private ChatbotProperties chatbotProperties;
    private MessageEventHandler messageEventHandler;

    private final MessageRequest messageRequest = JsonToValue(MessageRequest.class, "/json/NewMessageRequest.json");

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        messageEventHandler = new MessageEventHandler(Collections.singletonList(
                new MessageSenderBrands(viberWebClient, chatbotProperties, userService, keyBoardService)));
    }

//    @Test
//    public void getSender() {
//        MessageSender sender = messageEventHandler.getSender(messageRequest);
//        assertEquals(MessageSenderBrands.class, sender.getClass());
//    }
}