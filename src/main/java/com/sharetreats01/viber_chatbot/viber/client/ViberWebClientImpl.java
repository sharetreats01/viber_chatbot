package com.sharetreats01.viber_chatbot.viber.client;

import com.sharetreats01.viber_chatbot.viber.dto.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.SendMessageResponse;
import com.sharetreats01.viber_chatbot.viber.dto.SetWebhookRequest;
import com.sharetreats01.viber_chatbot.viber.dto.SetWebhookResponse;
import com.sharetreats01.viber_chatbot.viber.properties.ViberProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

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
        WebClient.ResponseSpec responseSpec = viberWebClient.post().uri(viberProperties.getSendMessageUri())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve();
        return responseResolver.messageResolve(responseSpec, SendMessageResponse.class);
    }
}
