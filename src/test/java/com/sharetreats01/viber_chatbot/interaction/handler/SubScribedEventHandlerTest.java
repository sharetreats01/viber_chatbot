package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.CallbackRequestFactory;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.SubscribedRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.UserFactory;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.viber.service.KeyBoardService;
import com.sharetreats01.viber_chatbot.viber.support.KeyboardFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.InvocationTargetException;

import static org.mockito.Mockito.*;

class SubScribedEventHandlerTest {
    @Mock
    private UserService userService;

    @Mock
    private ViberWebClient viberWebClient;

    @Mock
    private KeyBoardService keyBoardService;

    @InjectMocks
    private SubScribedEventHandler handler;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void 구독_이벤트_테스트() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SubscribedRequest request = CallbackRequestFactory.createSubscribedRequest(
                1457764197627L,
                UserFactory.createUserDto("01234567890A=", "John McClane", "http://avatar.example.com", "UK", "en", 1),
                4912661846655238145L);
        SendTextMessageRequest textMessageRequest = new SendTextMessageRequest(request.getUser().getId(), "Viber  Treats", "", "subscribe", request.getUser().getApiVersion(), "text");
        when(keyBoardService.findCategory()).thenReturn(any(String.class));


        handler.handleEvent(request);

        verify(userService, times(1)).subscribe(request.getUser().getId());
        verify(viberWebClient, times(1)).sendMessage(textMessageRequest);
    }
}