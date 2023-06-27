package com.sharetreats01.viber_chatbot.order.client;

import com.sharetreats01.viber_chatbot.order.dto.request.OrderDetailRequest;
import com.sharetreats01.viber_chatbot.order.dto.response.GetOrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
public class OrderClientImpl implements OrderClient{
    private WebClient apiClient;

    @Value("${domain.sharetreats.mock}")
    private String domain;

    public GetOrderDetail request(OrderDetailRequest request) {
        return this.apiClient.post()
            .uri("")
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .retrieve()
            .bodyToMono(GetOrderDetail.class)
            .block();
    }

    @Override
    public GetOrderDetail getOrderDetail(OrderDetailRequest request) {
        return null;
    }

    @Override
    public void createOrder() {

    }
}
