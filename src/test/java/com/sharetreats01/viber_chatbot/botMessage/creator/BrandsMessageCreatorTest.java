package com.sharetreats01.viber_chatbot.botMessage.creator;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.creator.BrandsMessageCreator;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.service.keyboard.KeyBoardService;
import com.sharetreats01.viber_chatbot.callback.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.botMessage.util.TrackingDataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BrandsMessageCreatorTest extends AbstractMockTest {
    @Mock
    private KeyBoardService keyBoardService;

    @Mock
    private ChatbotProperties chatbotProperties;

    @Mock
    private TrackingDataUtils trackingDataUtils;

    @InjectMocks
    private BrandsMessageCreator messageCreator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    @DisplayName("updateTrackingData 메서드 실행 시 세션값과 BRANDS 상태 값을 가진 tracking_data 반환")
//    public void updateTrackingDataTest() {
//        String trackingData = "11ee1982-1bef-3bc7-8664-cf1e0bd45cbf:BRANDS";
//        when(trackingDataUtils.createTrackingData()).thenReturn(trackingData);
//        MessageRequest request = JsonToValue(MessageRequest.class, "/json/FirstMessageRequest.json");
//        String result = messageCreator.updateTrackingData(request.getMessage().getTrackingData());
//
//        assertEquals(trackingData, result);
//    }

    @Test
    @DisplayName("createMessageRequest 메서드 실행 시 브랜드 리스트 키보드 프로퍼티를 가진 SendTextMessageRequest 객체 반환")
    public void createMessageRequestTest() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/FirstMessageRequest.json");
        String trackingData = "11ee1982-1bef-3bc7-8664-cf1e0bd45cbf:BRANDS";
        String keyBoard = "brands keyboard";
        String chatbotName = "Viber Treats";
        String chatbotAvatar = "Viber Avatar";

        when(keyBoardService.findBrands()).thenReturn(keyBoard);
        when(chatbotProperties.getBotName()).thenReturn(chatbotName);
        when(chatbotProperties.getBotAvatar()).thenReturn(chatbotAvatar);

        SendMessageRequest result = messageCreator.createMessageRequest(request);

        assertNotNull(result);
        assertEquals(trackingData, result.getTrackingData());
        assertEquals(request.getSender().getId(), result.getReceiver());
    }
}