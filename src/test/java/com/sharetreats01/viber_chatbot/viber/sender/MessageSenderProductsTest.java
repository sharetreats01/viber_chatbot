package com.sharetreats01.viber_chatbot.viber.sender;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.service.RichMediaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MessageSenderProductsTest extends AbstractMockTest {
    @Mock
    private RichMediaService richMediaService;

    @Mock
    private ViberWebClient viberWebClient;

    @InjectMocks
    private MessageSenderProducts productProcessor;

    private MessageRequest messageRequest = JsonToValue(MessageRequest.class, "/json/ProductMessageRequest.json");


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("BRANDS 상태 반환")
    public void getSenderKey() {
        State state = productProcessor.getSenderKey();
        assertEquals(state, State.BRANDS);
    }

    @Test
    @DisplayName("트래킹 데이터 처리 및 사용자에게 응답메시지 전송")
    public void process() {
        productProcessor.send(messageRequest);
        verify(viberWebClient, times(1)).sendMessage(any(SendMessageRequest.class));
    }


    @Test
    @DisplayName("전송받은 추적데이터 상태값: SUBSCRIBED\n새로운 추적데이터 상태값: PRODUCT")
    public void createSendMessageRequestTest() {
        when(richMediaService.findProductsByBrand(messageRequest.getMessage().getText())).thenReturn(any(String.class));
        SendMessageRequest sendMessageRequest = productProcessor.createSendMessageRequest(messageRequest);

        verify(richMediaService, times(1)).findProductsByBrand(messageRequest.getMessage().getText());

        assertEquals(sendMessageRequest.getReceiver(), "01234567890A=");
//        assertEquals(State.BRANDS);
    }
}