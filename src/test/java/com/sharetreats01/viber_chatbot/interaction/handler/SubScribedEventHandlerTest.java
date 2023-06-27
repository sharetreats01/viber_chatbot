package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.CallbackDtoFactory;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.Subscribed;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.UserDtoFactory;
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
        Callback callback = CallbackDtoFactory.createSubscribed(
                Event.SUBSCRIBED, 1457764197627L,
                UserDtoFactory.createUserDto("01234567890A=", "John McClane", "http://avatar.example.com", "UK", "en", 1),
                4912661846655238145L);
        Subscribed subscribed = callback.buildSubscribed();
        handler.handleEvent(callback);

        verify(userService, times(1)).subscribe(subscribed.getUser().getId());
    }
}