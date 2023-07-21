package com.sharetreats01.viber_chatbot.client.product.client;

import com.sharetreats01.viber_chatbot.client.product.properties.ProductApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class ProductApiClientConfig {
    private final ProductApiProperties productApiProperties;
    @Bean
    public WebClient productApiClient() {
        return WebClient.builder()
                .baseUrl(productApiProperties.getProductDomain())
                .build();
    }

}
