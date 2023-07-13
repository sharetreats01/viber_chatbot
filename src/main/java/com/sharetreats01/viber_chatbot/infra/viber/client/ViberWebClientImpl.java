package com.sharetreats01.viber_chatbot.infra.viber.client;

import com.sharetreats01.viber_chatbot.infra.viber.dto.request.GetUserDetailsRequest;
import com.sharetreats01.viber_chatbot.infra.viber.properties.ViberProperties;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendKeyboardRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.response.GetUserDetailsResponse;
import com.sharetreats01.viber_chatbot.infra.viber.dto.response.SendMessageResponse;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SetWebhookRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.response.SetWebhookResponse;
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
    private final WebClientResponseResolver responseResolver;


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
        WebClient.ResponseSpec responseSpec = viberWebClient.post().uri(viberProperties.getSendMessageUri())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve();
        SendMessageResponse response = responseResolver.messageResolve(responseSpec, SendMessageResponse.class);
        ViberWebClientResponseResolver.handleSendMessageResponse(response);
        return response;
    }

    @Override
    public GetUserDetailsResponse getUserDetails(GetUserDetailsRequest request) {
        WebClient.ResponseSpec responseSpec = viberWebClient.post().uri(viberProperties.getGetUserDetailsUri())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve();
        return responseResolver.messageResolve(responseSpec, GetUserDetailsResponse.class);
    }

    @Override
    public Void sendKeyboard(SendKeyboardRequest request) {
        WebClient.ResponseSpec responseSpec = viberWebClient.post().uri(viberProperties.getSendMessageUri())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve();
        return responseResolver.messageResolve(responseSpec, Void.class);
    }
}
