package com.sharetreats01.viber_chatbot.client.order.client;

import com.sharetreats01.viber_chatbot.client.order.dto.request.OrderRequest;
import com.sharetreats01.viber_chatbot.client.order.dto.response.OrderSuccessResponse;

public interface OrderApiClient {
    OrderSuccessResponse createOrder(OrderRequest request);
}
