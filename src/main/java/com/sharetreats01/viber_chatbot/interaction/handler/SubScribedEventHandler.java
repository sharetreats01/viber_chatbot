package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.SubscribedRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.SubscribeResponse;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubScribedEventHandler implements CallbackEventHandler<SubscribedRequest, SubscribeResponse> {
    private final UserService userService;

    @Override
    public Class<SubscribedRequest> getCallbackType() {
        return SubscribedRequest.class;
    }

    @Override
    public SubscribeResponse handleEvent(SubscribedRequest request) {
        userService.subscribe(request.getUser().getId());
        return null;
    }
}
