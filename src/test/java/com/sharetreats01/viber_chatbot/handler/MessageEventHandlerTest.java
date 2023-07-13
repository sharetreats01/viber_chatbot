package com.sharetreats01.viber_chatbot.handler;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.config.TestMessageHandlerConfiguration;
import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.support.handler.message.MessageHandler;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.mockito.Mockito.*;

class MessageEventHandlerTest extends AbstractMockTest {
    private final Map<State, MessageHandler> handlers = TestMessageHandlerConfiguration.getMessageHandlers();
    private final TrackingDataUtils trackingDataUtils = mock(TrackingDataUtils.class);
    private MessageEventHandler messageEventHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.messageEventHandler = new MessageEventHandler(handlers, trackingDataUtils);
    }

    @Test
    @DisplayName("messageBrandHandler.handle() 실행")
    public void newMessage_getHandler() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/FirstMessageRequest.json");
        when(trackingDataUtils.getState(request.getMessage().getTrackingData())).thenReturn(State.BRANDS);

        messageEventHandler.handleEvent(request);

        verify(handlers.get(State.BRANDS)).handle(request);
    }

    @Test
    @DisplayName("messageProductsHandler.handle() 실행")
    public void selectBrand_getHandler() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/SelectBrandMessageRequest.json");
        when(trackingDataUtils.getState(request.getMessage().getTrackingData())).thenReturn(State.PRODUCTS);

        messageEventHandler.handleEvent(request);

        verify(handlers.get(State.PRODUCTS)).handle(request);
    }

    @Test
    @DisplayName("messageDetailHandler.handle() 실행")
    public void selectDetail_getHandler() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/SelectProductMessageRequest.json");
        when(trackingDataUtils.getState(request.getMessage().getTrackingData())).thenReturn(State.DETAIL);

        messageEventHandler.handleEvent(request);

        verify(handlers.get(State.DETAIL)).handle(request);
    }

    @Test
    @DisplayName("messageTreatHandler.handle() 실행")
    public void treat_getHandler() {
        MessageRequest request = JsonToValue(MessageRequest.class, "/json/TreatProductMessageRequest.json");
        when(trackingDataUtils.getState(request.getMessage().getTrackingData())).thenReturn(State.TREAT);

        messageEventHandler.handleEvent(request);
        verify(handlers.get(State.TREAT)).handle(request);
    }
}