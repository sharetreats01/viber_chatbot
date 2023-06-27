package com.sharetreats01.viber_chatbot.viber.client;

import com.sharetreats01.viber_chatbot.viber.dto.request.SetWebhookRequest;
import com.sharetreats01.viber_chatbot.viber.dto.response.SetWebhookResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ViberRetrofitClient {
    @POST("/pa/set_webhook")
    Call<SetWebhookResponse> sendWebhookSetting(@Body SetWebhookRequest request);
}
