package com.sharetreats01.viber_chatbot.support.handler.message;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.callback.handler.message.MessageTreatHandler;
import com.sharetreats01.viber_chatbot.client.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.creator.TreatMessageCreator;
import com.sharetreats01.viber_chatbot.callback.handler.treat.TreatConstantsHandler;
import com.sharetreats01.viber_chatbot.callback.handler.treat.TreatMessageLinkerFriend;
import com.sharetreats01.viber_chatbot.callback.handler.treat.TreatMessageLinkerMe;
import com.sharetreats01.viber_chatbot.botMessage.util.TreatDataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class MessageTreatHandlerMockTest extends AbstractMockTest {
    @Mock
    ViberWebClient viberWebClient;

    @Mock
    TreatDataUtils treatDataUtils;

    @Mock
    TreatMessageCreator messageCreator;

    @Mock
    TreatMessageLinkerFriend treatMessageLinkerFriend;

    @Mock
    TreatMessageLinkerMe treatMessageLinkerMe;

    @Mock
    TreatConstantsHandler constantsHandler;

    @InjectMocks
    MessageTreatHandler handler;

    String trackingData;
    String input;
    String identifier;
    List<String> treatParts;
    MessageRequest request;
    SendMessageRequest sendMessageRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.handler = new MessageTreatHandler(viberWebClient, treatDataUtils, messageCreator, List.of(treatMessageLinkerMe, treatMessageLinkerFriend));
    }

    @Test
    @DisplayName("Treat 선물 대상자 선택 메시지")
    public void handleByTreatTarget() {
        request = JsonToValue(MessageRequest.class, "/json/TreatProductMessageRequest.json");
        sendMessageRequest = mock(SendMessageRequest.class);
        trackingData = request.getMessage().getTrackingData();
        input = request.getMessage().getText();
        identifier = "TREAT";
        treatParts = List.of("TREAT");

        when(treatDataUtils.combineTreatData(trackingData, input)).thenReturn(treatParts);
        when(treatDataUtils.getTreatLinkerIdentifier(treatParts)).thenReturn(identifier);
        when(messageCreator.successMessage(request, treatParts)).thenReturn(sendMessageRequest);

        handler.handle(request);

        verify(treatDataUtils, times(1)).combineTreatData(trackingData, input);
        verify(treatDataUtils, times(1)).getTreatLinkerIdentifier(treatParts);
        verify(messageCreator, times(1)).successMessage(request, treatParts);
        verify(viberWebClient, times(1)).sendMessage(sendMessageRequest);
    }

    @Test
    @DisplayName("Treat FRIEND 입력")
    void handByTreatFriend() {
        request = JsonToValue(MessageRequest.class, "/json/TreatFriendMessageRequest.json");
        sendMessageRequest = mock(SendMessageRequest.class);
        trackingData = request.getMessage().getTrackingData();
        input = request.getMessage().getText();
        identifier = "FRIEND";
        treatParts = List.of("TREAT", "FRIEND");

        when(treatDataUtils.combineTreatData(trackingData, input)).thenReturn(treatParts);
        when(treatDataUtils.getTreatLinkerIdentifier(treatParts)).thenReturn(identifier);
        when(treatMessageLinkerFriend.canLink(identifier)).thenReturn(true);
        when(treatMessageLinkerFriend.getHandler(request, treatParts)).thenReturn(constantsHandler);
        when(constantsHandler.handle(request, treatParts)).thenReturn(sendMessageRequest);

        handler.handle(request);

        verify(treatDataUtils, times(1)).combineTreatData(trackingData, input);
        verify(treatDataUtils, times(1)).getTreatLinkerIdentifier(treatParts);
        verify(messageCreator, never()).successMessage(request, treatParts);
        verify(viberWebClient, times(1)).sendMessage(sendMessageRequest);
    }
}