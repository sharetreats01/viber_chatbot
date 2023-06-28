package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.UnsubscribeRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.UnsubscribeResponse;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UnsubscribedEventHandler implements CallbackEventHandler<UnsubscribeRequest, UnsubscribeResponse> {
    private final UserService userService;

    @Override
    public Event getCallbackEvent() {
        return Event.UNSUBSCRIBED;
    }

    @Override
    public UnsubscribeResponse handleEvent(UnsubscribeRequest request) {
        userService.unsubscribe(request.getUserId());
        return null;
    }
}
