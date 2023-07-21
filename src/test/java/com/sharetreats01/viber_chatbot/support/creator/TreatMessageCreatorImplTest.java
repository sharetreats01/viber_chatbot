package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.AbstractMockTest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.callback.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.botMessage.service.message.MessageService;
import com.sharetreats01.viber_chatbot.botMessage.creator.TreatMessageCreatorImpl;
import com.sharetreats01.viber_chatbot.botMessage.util.TreatDataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TreatMessageCreatorImplTest extends AbstractMockTest {
    @Mock
    private MessageService messageService;

    @Mock
    private TreatDataUtils treatDataUtils;

    @Mock
    private ChatbotProperties chatbotProperties;

    @InjectMocks
    private TreatMessageCreatorImpl messageCreator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Treat 대상 선택 메시지")
    public void treat_targetMessage() {
        MessageRequest messageRequest = JsonToValue(MessageRequest.class, "/json/TreatProductMessageRequest.json");

    }

}