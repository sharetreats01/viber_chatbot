package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.SeenRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.SeenResponse;
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
