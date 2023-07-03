package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.SubscribedRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.TrackingJSONData;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.SubscribeResponse;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.viber.service.KeyBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubScribedEventHandler implements CallbackEventHandler<SubscribedRequest, SubscribeResponse> {
    private final UserService userService;
    private final ViberWebClient viberWebClient;
    private final KeyBoardService keyBoardService;
//    private final MessageService messageService;

    @Override
    public Class<SubscribedRequest> getCallbackType() {
        return SubscribedRequest.class;
    }

    @Override
    public SubscribeResponse handleEvent(SubscribedRequest request) {
        userService.subscribe(request.getUser().getId());
        SendTextMessageRequest textMessageRequest = new SendTextMessageRequest(request.getUser().getId(), "Viber Treats", "", request.getUser().getApiVersion(), "Thank you for Subscribe!", new TrackingJSONData());
        textMessageRequest.setKeyboard(keyBoardService.findBrands());
        viberWebClient.sendMessage(textMessageRequest);
        return null;
    }
}
