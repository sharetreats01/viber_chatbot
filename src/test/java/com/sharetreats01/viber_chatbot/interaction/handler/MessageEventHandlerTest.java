package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.sender.MessageSender;
import com.sharetreats01.viber_chatbot.viber.sender.MessageSenderBrands;
import com.sharetreats01.viber_chatbot.viber.service.KeyBoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MessageEventHandlerTest extends AbstractMockTest {
    @Mock
    private UserService userService;
    @Mock
    private TrackingDataUtils trackingDataUtils;
    @Mock
    private KeyBoardService keyBoardService;
    @Mock
    private ViberWebClient viberWebClient;
    private MessageEventHandler messageEventHandler;

    private final MessageRequest messageRequest = JsonToValue(MessageRequest.class, "/json/NewMessageRequest.json");

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        messageEventHandler = new MessageEventHandler(Collections.singletonList(
                new MessageSenderBrands(viberWebClient, userService, keyBoardService)));
    }

    @Test
    public void getSender() {
        MessageSender sender = messageEventHandler.getSender(messageRequest);
        assertEquals(MessageSenderBrands.class, sender.getClass());
    }
}