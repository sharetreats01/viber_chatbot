package com.sharetreats01.viber_chatbot.callback.handler.event;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.FailedRequest;
import com.sharetreats01.viber_chatbot.callback.dto.response.event.FailedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FailedEventHandler implements CallbackEventHandler<FailedRequest, FailedResponse> {
    @Override
    public Class<FailedRequest> getCallbackType() {
        return FailedRequest.class;
    }

    @Override
    public FailedResponse handleEvent(FailedRequest request) {
        return null;
    }
}
