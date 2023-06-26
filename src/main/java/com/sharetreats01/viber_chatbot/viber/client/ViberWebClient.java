package com.sharetreats01.viber_chatbot.viber.client;

import com.sharetreats01.viber_chatbot.viber.dto.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.SendMessageResponse;
import com.sharetreats01.viber_chatbot.viber.dto.SetWebhookRequest;
import com.sharetreats01.viber_chatbot.viber.dto.SetWebhookResponse;

public interface ViberWebClient {
    SetWebhookResponse sendWebhookSetting(SetWebhookRequest request);
    SendMessageResponse sendMessage(SendMessageRequest request);
}
