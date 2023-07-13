package com.sharetreats01.viber_chatbot.handler;

import com.sharetreats01.viber_chatbot.dto.callback.request.SubscribedRequest;
import com.sharetreats01.viber_chatbot.dto.callback.response.SubscribeResponse;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.support.creator.BrandsMessageCreator;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubScribedEventHandler implements CallbackEventHandler<SubscribedRequest, SubscribeResponse> {
    private final UserService userService;
    private final ViberWebClient viberWebClient;
    private final BrandsMessageCreator brandsMessageCreator;
    private final TrackingDataUtils trackingDataUtils;

    @Override
    public Class<SubscribedRequest> getCallbackType() {
        return SubscribedRequest.class;
    }

    @Override
    public SubscribeResponse handleEvent(SubscribedRequest request) {
        userService.subscribe(request.getUser().getId());
        SendMessageRequest messageRequest = brandsMessageCreator.createMessage(request.getUser().getId(), trackingDataUtils.createTrackingData());
        viberWebClient.sendMessage(messageRequest);
        return null;
    }
}
