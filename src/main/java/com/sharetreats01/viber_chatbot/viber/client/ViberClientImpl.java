package com.sharetreats01.viber_chatbot.viber.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linecorp.armeria.client.WebClient;
import com.linecorp.armeria.common.HttpResponse;
import com.sharetreats01.viber_chatbot.viber.dto.SetWebhookRequest;
import com.sharetreats01.viber_chatbot.viber.dto.SetWebhookResponse;
import com.sharetreats01.viber_chatbot.viber.properties.ViberProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//@Service
@RequiredArgsConstructor
public class ViberClientImpl implements ViberClient {
    private final ViberProperties viberProperties;
    private final WebClient viberWebClient;
    private final ObjectMapper objectMapper;


    @Override
    public SetWebhookResponse sendWebhookSetting(SetWebhookRequest request) throws JsonProcessingException {
        return null;
    }
}
