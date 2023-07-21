package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.State;
import com.sharetreats01.viber_chatbot.botMessage.creator.ProductDetailMessageCreator;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.service.message.RichMediaService;
import com.sharetreats01.viber_chatbot.botMessage.util.TrackingDataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductDetailMessageCreatorTest extends AbstractMockTest {
    @Mock
    TrackingDataUtils trackingDataUtils;

    @Mock
    RichMediaService richMediaService;

    @InjectMocks
    ProductDetailMessageCreator messageCreator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("사용자로부터 상품 ID를 입력받아 상품 상세 정보 반환")
    void createMessageRequestTest() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/SelectProductMessageRequest.json");
        String trackingData = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();
        String brand = "1";
        String productName = "1";


        when(trackingDataUtils.updateState(trackingData, input)).thenReturn(trackingData + "_" + 1 + ":" + State.DETAIL);
        when(trackingDataUtils.extractBrand(trackingData)).thenReturn("1");
        when(richMediaService.findProductDetailByProductId(brand, productName)).thenReturn(any(String.class));

        SendMessageRequest result = messageCreator.createMessageRequest(request);

        verify(richMediaService, times(1)).findProductDetailByProductId(brand, productName);
        verify(trackingDataUtils, times(1)).extractBrand(trackingData);
        verify(trackingDataUtils, times(1)).updateState(trackingData, input);

        assertEquals(trackingData + "_" + 1 + ":" + State.DETAIL, result.getTrackingData());
    }
}