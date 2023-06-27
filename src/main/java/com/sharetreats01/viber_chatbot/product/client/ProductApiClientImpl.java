package com.sharetreats01.viber_chatbot.product.client;

import com.sharetreats01.viber_chatbot.product.dto.response.AvailablePayments;
import com.sharetreats01.viber_chatbot.product.dto.response.BrandList;
import com.sharetreats01.viber_chatbot.product.dto.response.ProductDetail;
import com.sharetreats01.viber_chatbot.product.dto.response.ProductList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
public class ProductApiClientImpl {
    private WebClient productClient;

    @Value("${domain.sharetreats.mock}")
    private String domain;

    private String uri;

    public ProductApiClientImpl() {
        this.productClient = WebClient.builder()
            .baseUrl(domain)
            .build();
    }

    public BrandList getBrandList() {
        return this.productClient.get()
            .uri("https://4e765d5e-13d9-4ec3-a6e7-d21254d2dc43.mock.pstmn.io/products/1")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(BrandList.class)
            .block();
    }

    public ProductDetail getProductDetail() {
        return this.productClient.get()
            .uri("https://4e765d5e-13d9-4ec3-a6e7-d21254d2dc43.mock.pstmn.io/products/1")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(ProductDetail.class)
            .block();
    }

    public ProductList getProducts() {
        return this.productClient.get()
            .uri("https://4e765d5e-13d9-4ec3-a6e7-d21254d2dc43.mock.pstmn.io/products/list?partners=mcdonalds/")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(ProductList.class)
            .block();
    }

    public AvailablePayments getProductPayments(String productId) {
        String requestUri = String.format("uri", productId);
        return this.productClient.get().uri(domain + requestUri)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(AvailablePayments.class)
            .block();
    }


}
