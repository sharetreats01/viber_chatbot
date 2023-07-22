package com.sharetreats01.viber_chatbot.callback.handler.event;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.SubscribedRequest;
import com.sharetreats01.viber_chatbot.callback.dto.response.event.SubscribeResponse;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.creator.BrandsMessageCreator;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.client.viber.client.ViberWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubScribedEventHandler implements CallbackEventHandler<SubscribedRequest, SubscribeResponse> {
    private final UserService userService;
    private final ViberWebClient viberWebClient;
    private final BrandsMessageCreator brandsMessageCreator;

    @Override
    public Class<SubscribedRequest> getCallbackType() {
        return SubscribedRequest.class;
    }

    @Override
    public SubscribeResponse handleEvent(SubscribedRequest request) {
        userService.subscribe(request.getUser().getId());
        SendMessageRequest messageRequest = brandsMessageCreator.createMessageRequest(request);
        viberWebClient.sendMessage(messageRequest);
        return null;
    }
}
