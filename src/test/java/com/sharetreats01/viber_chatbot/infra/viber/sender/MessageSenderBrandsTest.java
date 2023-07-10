package com.sharetreats01.viber_chatbot.infra.viber.sender;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.infra.viber.sender.MessageSenderBrands;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.service.KeyBoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MessageSenderBrandsTest extends AbstractMockTest {
    @Mock
    private UserService userService;

    @Mock
    private KeyBoardService keyBoardService;

    @Mock
    private ViberWebClient viberWebClient;

    @InjectMocks
    private MessageSenderBrands subscribeProcessor;

    private final MessageRequest messageRequest = JsonToValue(MessageRequest.class, "/json/NewMessageRequest.json");
    private final String keyboard = JsonToString("/json/BrandKeyboard.json");

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Null 반환")
    public void getTrackingType() {
        assertNull(subscribeProcessor.getSenderKey());
    }

    @Test
    @DisplayName("메시지생성 및 카테고리 키보드 오브젝트 생성")
    public void createSendMessageRequest() {
        when(keyBoardService.findBrands()).thenReturn(keyboard);
        SendMessageRequest request = subscribeProcessor.createSendMessageRequest(messageRequest);

        assertNotNull(request.getTrackingData());
        assertEquals(keyboard, request.getKeyboard());
    }

    @Test
    @DisplayName("Tracking Data 설정 - Status.NEW")
    public void setTrackingData() {
        when(keyBoardService.findBrands()).thenReturn(keyboard);
        SendMessageRequest request = subscribeProcessor.createSendMessageRequest(messageRequest);

        assertEquals(State.NEW, TrackingDataUtils.getState(request.getTrackingData()));
    }

    @Test
    public void process() {
        subscribeProcessor.send(messageRequest);
        verify(userService, times(1)).subscribe(messageRequest.getSender().getId());
        verify(viberWebClient, times(1)).sendMessage(any(SendMessageRequest.class));
    }
}