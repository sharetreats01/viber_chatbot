package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.Subscribed;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubScribedEventHandler implements CallbackEventHandler {
    private final UserService userService;

    @Override
    public Event getCallbackEvent() {
        return Event.SUBSCRIBED;
    }

    @Override
    public Void handleEvent(Callback callback) {
        Subscribed subscribed = callback.buildSubscribed();
        userService.subscribe(subscribed.getUser());
        return null;
    }
}
