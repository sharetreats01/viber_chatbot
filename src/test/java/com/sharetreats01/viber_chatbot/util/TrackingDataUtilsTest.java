package com.sharetreats01.viber_chatbot.util;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TrackingDataUtilsTest extends AbstractMockTest {
    @Mock
    private UUIDGenerator uuidGenerator;
    @InjectMocks
    private TrackingDataUtils trackingDataUtils;

    private String session = "11ee1982-1bef-3bc7-8664-cf1e0bd45cbf";
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(uuidGenerator.createTimeBasedUUID()).thenReturn(UUID.fromString(session));
    }

    @Test
    @DisplayName("브랜드 선택을 한 경우 getState의 반환 값은 PRODUCTS")
    public void selectBrand() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/SelectBrandMessageRequest.json");

        State result = trackingDataUtils.getState(request.getMessage().getTrackingData(), request.getMessage().getText());

        assertEquals(State.PRODUCTS, result);
    }

    @Test
    @DisplayName("상품 선택을 한 경우 getState의 반환 값 DETAIL")
    public void selectProduct() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/SelectProductMessageRequest.json");

        State result = trackingDataUtils.getState(request.getMessage().getTrackingData(), request.getMessage().getText());

        assertEquals(State.DETAIL, result);
    }

    @Test
    @DisplayName("상품선택 후 Treat버튼을 누를 경우 반환 값 Treat")
    public void selectTreat() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatProductMessageRequest.json");

        State result = trackingDataUtils.getState(request.getMessage().getTrackingData(), request.getMessage().getText());

        assertEquals(State.TREAT, result);
    }

    @Test
    @DisplayName("")
    public void extractTreatFor() {

    }
}