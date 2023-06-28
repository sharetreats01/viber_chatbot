package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.CallbackRequestFactory;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.SubscribedRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.UserFactory;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.user.service.UserService;
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

    @InjectMocks
    private SubScribedEventHandler handler;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void 구독_이벤트_테스트() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SubscribedRequest subscribedRequest = CallbackRequestFactory.createSubscribedRequest(
                1457764197627L,
                UserFactory.createUserDto("01234567890A=", "John McClane", "http://avatar.example.com", "UK", "en", 1),
                4912661846655238145L);
        handler.handleEvent(subscribedRequest);

        verify(userService, times(1)).subscribe(subscribedRequest.getUser().getId());
    }
}