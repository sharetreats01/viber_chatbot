package com.sharetreats01.viber_chatbot.handler;

import com.sharetreats01.viber_chatbot.dto.callback.request.UnsubscribedRequest;
import com.sharetreats01.viber_chatbot.dto.callback.response.UnsubscribeResponse;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UnsubscribedEventHandler implements CallbackEventHandler<UnsubscribedRequest, UnsubscribeResponse> {
    private final UserService userService;

    @Override
    public Class<UnsubscribedRequest> getCallbackType() {
        return UnsubscribedRequest.class;
    }

    @Override
    public UnsubscribeResponse handleEvent(UnsubscribedRequest request) {
        userService.unsubscribe(request.getUserId());
        return null;
    }
}
