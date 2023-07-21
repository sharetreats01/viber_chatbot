package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.callback.handler.event.SubScribedEventHandler;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.client.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.botMessage.service.keyboard.KeyBoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.InvocationTargetException;

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
//        SubscribedRequest request = CallbackRequestFactory.createSubscribedRequest(
//                1457764197627L,
//                UserFactory.createUserDto("01234567890A=", "John McClane", "http://avatar.example.com", "UK", "en", 1),
//                4912661846655238145L);
//        SendTextMessageRequest textMessageRequest = new SendTextMessageRequest(request.getUser().getId(), "Viber  Treats", "", "subscribe", request.getUser().getApiVersion(), "Thank you for Subscribe!");
//        String keyboard = null;
//        when(keyBoardService.findCategory()).thenReturn(keyboard);
//
//
//        handler.handleEvent(request);

//        ArgumentCaptor<SendMessageRequest> captor = ArgumentCaptor.forClass(SendMessageRequest.class);
//        verify(viberWebClient, times(1)).sendMessage(captor.capture());
//        SendMessageRequest actualRequest = captor.getValue();
//        System.out.println(actualRequest);


//        verify(userService, times(1)).subscribe(request.getUser().getId());
//        verify(viberWebClient, times(1)).sendMessage(textMessageRequest);
    }
}