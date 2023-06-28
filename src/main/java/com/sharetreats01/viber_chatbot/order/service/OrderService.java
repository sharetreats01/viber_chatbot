package com.sharetreats01.viber_chatbot.order.service;

import com.sharetreats01.viber_chatbot.order.client.OrderApiClient;
import com.sharetreats01.viber_chatbot.order.dto.request.OrderByBotRequest;
import com.sharetreats01.viber_chatbot.order.dto.request.OrderRequest;
import com.sharetreats01.viber_chatbot.order.dto.response.OrderSuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderApiClient orderApiClient;

    public OrderSuccessResponse createOrderByBot(OrderByBotRequest request) {
        //따로 변환 클래스 작성 필요 Or 따로 Service 단에서 DTO 변환하기 ...

        return orderApiClient.createOrder(OrderRequest.botOrderRequestToOrderRequest(request));
    }
}
