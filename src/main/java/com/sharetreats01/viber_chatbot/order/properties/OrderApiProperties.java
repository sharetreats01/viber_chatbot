package com.sharetreats01.viber_chatbot.order.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("classpath:properties/sharetreats/sharetreats.properties")
public class OrderApiProperties {
    @Value("${sharetreats.api.url}")
    private String OrderApiDomain;

    @Value("${sharetreats.api.post-order}")
    private String orderCreateUri;

}
