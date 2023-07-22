package com.sharetreats01.viber_chatbot.client.viber.client;

import com.sharetreats01.viber_chatbot.client.viber.dto.request.GetUserDetailsRequest;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendKeyboardRequest;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SetWebhookRequest;
import com.sharetreats01.viber_chatbot.client.viber.dto.response.GetUserDetailsResponse;
import com.sharetreats01.viber_chatbot.client.viber.dto.response.SendMessageResponse;
import com.sharetreats01.viber_chatbot.client.viber.dto.response.SetWebhookResponse;

public interface ViberWebClient {
    SetWebhookResponse sendWebhookSetting(SetWebhookRequest request);
    SendMessageResponse sendMessage(SendMessageRequest request);
    GetUserDetailsResponse getUserDetails(GetUserDetailsRequest request);
    Void sendKeyboard(SendKeyboardRequest request);
}
