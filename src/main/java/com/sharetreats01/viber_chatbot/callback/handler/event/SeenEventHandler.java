package com.sharetreats01.viber_chatbot.callback.handler.event;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.SeenRequest;
import com.sharetreats01.viber_chatbot.callback.dto.response.event.SeenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeenEventHandler implements CallbackEventHandler<SeenRequest, SeenResponse> {
    @Override
    public Class<SeenRequest> getCallbackType() {
        return SeenRequest.class;
    }

    @Override
    public SeenResponse handleEvent(SeenRequest request) {
        return null;
    }
}
