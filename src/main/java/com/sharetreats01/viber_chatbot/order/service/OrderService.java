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
        //따로 변환 클래스 작성 필요 Or 따로 Service 단에서 DTO 변환하기 ...
        OrderSuccessResponse response = orderApiClient.createOrder(
            OrderRequest.botOrderRequestToOrderRequest(request)
        );
        // 성공 시 -> orderRequest를 OrderEntity로 변환,저장
        return response;
    }
}
