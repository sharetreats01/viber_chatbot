package com.sharetreats01.viber_chatbot.handler;

import com.sharetreats01.viber_chatbot.dto.callback.request.SubscribedRequest;
import com.sharetreats01.viber_chatbot.dto.callback.response.SubscribeResponse;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.service.KeyBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubScribedEventHandler implements CallbackEventHandler<SubscribedRequest, SubscribeResponse> {
    private final UserService userService;
    private final ViberWebClient viberWebClient;
    private final KeyBoardService keyBoardService;

    @Override
    public Class<SubscribedRequest> getCallbackType() {
        return SubscribedRequest.class;
    }

    @Override
    public SubscribeResponse handleEvent(SubscribedRequest request) {
        userService.subscribe(request.getUser().getId());
        SendTextMessageRequest textMessageRequest = new SendTextMessageRequest(request.getUser().getId(), "Viber Treats", "", request.getUser().getApiVersion(), "Thank you for Subscribe!");
        textMessageRequest.setKeyboard(keyBoardService.findBrands());
        viberWebClient.sendMessage(textMessageRequest);
        return null;
    }
}
