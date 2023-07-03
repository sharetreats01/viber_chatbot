package com.sharetreats01.viber_chatbot.product.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("classpath:properties/sharetreats/sharetreats.properties")
public class ProductApiProperties {
    @Value("${sharetreats.api.url}")
    private String ProductDomain;

    @Value("${sharetreats.api.get-payments-list}")
    private String ProductPaymentListUri;

    @Value("${sharetreats.api.get-brand-list}")
    private String BrandListUri;

    @Value("${sharetreats.api.get-product-detail}")
    private String ProductDetailUri;

}
