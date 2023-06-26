package com.sharetreats01.viber_chatbot.viber.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sharetreats01.viber_chatbot.viber.dto.SetWebhookRequest;
import com.sharetreats01.viber_chatbot.viber.dto.SetWebhookResponse;

public interface ViberClient {
    SetWebhookResponse sendWebhookSetting(SetWebhookRequest request) throws JsonProcessingException;
}
