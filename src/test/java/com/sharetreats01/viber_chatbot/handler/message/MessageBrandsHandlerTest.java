package com.sharetreats01.viber_chatbot.handler.message;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.callback.handler.message.MessageBrandsHandler;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.creator.BrandsMessageCreator;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.client.viber.client.ViberWebClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class MessageBrandsHandlerTest extends AbstractMockTest {
    @Mock
    private ViberWebClient viberWebClient;

    @Mock
    private UserService userService;

    @Mock
    private BrandsMessageCreator messageCreator;

    @InjectMocks
    private MessageBrandsHandler messageSenderBrands;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("MessageBrandsHandler.handle() 테스트")
    public void handleTest() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/FirstMessageRequest.json");
        SendMessageRequest sendMessageRequest = mock(SendMessageRequest.class);
        when(messageCreator.createMessageRequest(request)).thenReturn(sendMessageRequest);

        messageSenderBrands.handle(request);

        verify(userService, times(1)).subscribe(request.getSender().getId());
        verify(messageCreator, times(1)).createMessageRequest(request);
        verify(viberWebClient, times(1)).sendMessage(sendMessageRequest);
    }
}