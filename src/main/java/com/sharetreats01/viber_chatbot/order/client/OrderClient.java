package com.sharetreats01.viber_chatbot.order.client;

import com.sharetreats01.viber_chatbot.order.dto.request.OrderDetailRequest;
import com.sharetreats01.viber_chatbot.order.dto.response.GetOrderDetail;

public interface OrderClient {
    GetOrderDetail getOrderDetail(OrderDetailRequest request);
    void createOrder();
}
