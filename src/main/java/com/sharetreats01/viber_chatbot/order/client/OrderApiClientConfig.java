package com.sharetreats01.viber_chatbot.order.client;

import com.sharetreats01.viber_chatbot.order.properties.OrderApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class OrderApiClientConfig {
    private final OrderApiProperties orderApiProperties;
    @Bean
    public WebClient orderApiClient() {
        return WebClient.builder()
                .baseUrl(orderApiProperties.getOrderApiDomain())
                .build();
    }

}
