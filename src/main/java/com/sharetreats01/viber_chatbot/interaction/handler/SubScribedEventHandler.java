package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.SubscribeRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.SubscribeResponse;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubScribedEventHandler implements CallbackEventHandler<SubscribeRequest, SubscribeResponse> {
    private final UserService userService;

    @Override
    public Event getCallbackEvent() {
        return Event.SUBSCRIBED;
    }

    @Override
    public SubscribeResponse handleEvent(SubscribeRequest request) {
        userService.subscribe(request.getUser().getId());
        return null;
    }
}
