package com.sharetreats01.viber_chatbot.order.client;

import com.sharetreats01.viber_chatbot.order.dto.request.OrderRequest;
import com.sharetreats01.viber_chatbot.order.dto.response.OrderSuccessResponse;

public interface OrderApiClient {
    OrderSuccessResponse createOrder(OrderRequest request);
}
