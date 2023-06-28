package com.sharetreats01.viber_chatbot.viber.client;

import com.sharetreats01.viber_chatbot.viber.dto.request.GetUserDetailsRequest;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.response.GetUserDetailsResponse;
import com.sharetreats01.viber_chatbot.viber.dto.response.SendMessageResponse;
import com.sharetreats01.viber_chatbot.viber.dto.request.SetWebhookRequest;
import com.sharetreats01.viber_chatbot.viber.dto.response.SetWebhookResponse;
import com.sharetreats01.viber_chatbot.viber.properties.ViberProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class ViberWebClientImpl implements ViberWebClient {
    private final WebClient viberWebClient;
    private final ViberProperties viberProperties;
    private final ViberWebClientResponseResolver responseResolver;


    @Override
    public SetWebhookResponse sendWebhookSetting(SetWebhookRequest request) {
        WebClient.ResponseSpec responseSpec = viberWebClient.post().uri(viberProperties.getSetWebhookUri())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve();
        return responseResolver.messageResolve(responseSpec, SetWebhookResponse.class);
    }

    @Override
    public SendMessageResponse sendMessage(SendMessageRequest request) {
        log.info("send_message: " + request);
        WebClient.ResponseSpec responseSpec = viberWebClient.post().uri(viberProperties.getSendMessageUri())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve();
        return responseResolver.messageResolve(responseSpec, SendMessageResponse.class);
    }

    @Override
    public GetUserDetailsResponse getUserDetails(GetUserDetailsRequest request) {
        log.info("get_user_details: " + request);
        WebClient.ResponseSpec responseSpec = viberWebClient.post().uri(viberProperties.getGetUserDetailsUri())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve();
        return responseResolver.messageResolve(responseSpec, com.sharetreats01.viber_chatbot.viber.dto.response.GetUserDetailsResponse.class);
    }
}
