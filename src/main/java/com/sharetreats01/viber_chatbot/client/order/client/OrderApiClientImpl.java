package com.sharetreats01.viber_chatbot.client.order.client;

import com.sharetreats01.viber_chatbot.client.order.properties.OrderApiProperties;
import com.sharetreats01.viber_chatbot.client.order.dto.request.OrderRequest;
import com.sharetreats01.viber_chatbot.client.order.dto.response.OrderSuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class OrderApiClientImpl implements OrderApiClient{
    private final WebClient orderApiClient;
    private final OrderApiProperties orderApiProperties;
    private final OrderApiClientResponseResolver responseResolver;
    @Override
    public OrderSuccessResponse createOrder(OrderRequest request) {
        WebClient.ResponseSpec responseSpec = orderApiClient.post()
                .uri(orderApiProperties.getOrderCreateUri())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
        return responseResolver.messageResolve(responseSpec, OrderSuccessResponse.class);
    }

}
