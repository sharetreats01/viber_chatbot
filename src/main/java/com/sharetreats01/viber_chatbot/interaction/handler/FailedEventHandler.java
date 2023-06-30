package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.FailedRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.FailedResponse;
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
