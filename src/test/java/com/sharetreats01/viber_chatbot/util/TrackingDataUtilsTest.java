package com.sharetreats01.viber_chatbot.util;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.config.MessageHandlerConfiguration;
import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {TrackingDataUtils.class, UUIDGenerator.class, MessageHandlerConfiguration.class})
class TrackingDataUtilsTest extends AbstractMockTest {
    @Autowired
    private TrackingDataUtils trackingDataUtils;

    private final String session = "11ee1982-1bef-3bc7-8664-cf1e0bd45cbf";

    @Test
    @DisplayName("사용자에게 첫 메시지를 받으면 BRANDS 반환")
    void getNextStateByFirstMessage() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/FirstMessageRequest.json");
        String tackingData = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        State result = trackingDataUtils.getNextState(tackingData, input);

        assertEquals(State.BRANDS, result);
    }

    @Test
    @DisplayName("사용자가 브랜드를 선택 한 경우")
    void getNextStateByBrandMessage() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/SelectBrandMessageRequest.json");
        String tackingData = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        State result = trackingDataUtils.getNextState(tackingData, input);

        assertEquals(State.PRODUCTS, result);
    }

    @Test
    @DisplayName("사용자가 상품을 선택 한 경우")
    void getNextStateByProductMessage() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/SelectProductMessageRequest.json");
        String tackingData = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        State result = trackingDataUtils.getNextState(tackingData, input);

        assertEquals(State.DETAIL, result);
    }

    @Test
    @DisplayName("사용자가 Treat 선택 한 경우")
    void getNextStateByDetailMessage() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/SelectTreatMessageRequest.json");
        String tackingData = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();

        State result = trackingDataUtils.getNextState(tackingData, input);

        assertEquals(State.TREAT, result);
    }
}