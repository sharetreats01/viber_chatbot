package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.Unsubscribed;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UnsubscribedEventHandler implements CallbackEventHandler {
    private final UserService userService;

    @Override
    public Event getCallbackEvent() {
        return Event.UNSUBSCRIBED;
    }

    @Override
    public Void handleEvent(Callback callback) {
        Unsubscribed unsubscribed = callback.buildUnsubscribed();
        userService.unsubscribe(unsubscribed.getUserId());
        return null;
    }
}
