package com.sharetreats01.viber_chatbot.handler.message;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.support.creator.ProductsMessageCreator;
import com.sharetreats01.viber_chatbot.support.handler.message.MessageProductsHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class MessageProductsHandlerTest extends AbstractMockTest {
    @Mock
    private ViberWebClient viberWebClient;

    @Mock
    private ProductsMessageCreator messageCreator;

    @InjectMocks
    private MessageProductsHandler messageProductsHandler;



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("선택한 브랜드에 대한 상품리스트 메시지 작성")
    public void handleTest() {
        MessageRequest messageRequest = JsonToValue(MessageRequest.class, "/json/SelectBrandMessageRequest.json");
        SendMessageRequest sendMessageRequest = mock(SendMessageRequest.class);
        when(messageCreator.createMessageRequest(messageRequest)).thenReturn(sendMessageRequest);

        messageProductsHandler.handle(messageRequest);

        verify(messageCreator, times(1)).createMessageRequest(messageRequest);
        verify(viberWebClient, times(1)).sendMessage(sendMessageRequest);
    }
}