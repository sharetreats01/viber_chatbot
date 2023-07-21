package com.sharetreats01.viber_chatbot.order.service;

import com.sharetreats01.viber_chatbot.client.order.client.OrderApiClient;

import com.sharetreats01.viber_chatbot.client.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;


import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderServiceTest {
    @Mock
    private OrderApiClient orderApiClient;
    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void requestOrderAndSuccessResponse() {
        // orderApiClient 행위를 Mock으로 작성을 해야한다.
//        Mockito.when(orderApiClient.createOrder(any(OrderRequest.class)))
//                .thenReturn(any(OrderSuccessResponse.class));

        // OrderRequest 작성 필요
//        OrderSuccessResponse response = orderService.createOrderByBot(any(OrderByBotRequest.class));
//        verify(orderApiClient, times(1)).createOrder(any(OrderRequest.class));
        //
    }

}
