package com.sharetreats01.viber_chatbot.order.service;

import com.sharetreats01.viber_chatbot.order.client.OrderApiClient;
import com.sharetreats01.viber_chatbot.order.dto.request.OrderByBotRequest;
import com.sharetreats01.viber_chatbot.order.dto.request.OrderRequest;
import com.sharetreats01.viber_chatbot.order.dto.response.OrderSuccessResponse;
import com.sharetreats01.viber_chatbot.order.repository.OrderBotRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderApiClient orderApiClient;
    private final OrderBotRepository orderBotRepository;

    public OrderSuccessResponse createOrderByBot(OrderByBotRequest request) {
        // request Mapper 시작, 

        // 주문 생성
        OrderSuccessResponse response = orderApiClient.createOrder(
            OrderRequest.botOrderRequestToOrderRequest(request)
        );
        return response;
    }


}
