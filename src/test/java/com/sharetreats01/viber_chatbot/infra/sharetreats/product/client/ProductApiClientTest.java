package com.sharetreats01.viber_chatbot.infra.sharetreats.product.client;

import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductApiClientTest {
    @Autowired
    private ProductApiClient productApiClient;


    @Test
    @DisplayName("Mock Server에서 제품 상세 받기")
    public void getProductDetail() {
        ProductDetailResponse productDetail1 = productApiClient.getProductDetail(1L);
        ProductDetailResponse productDetail2 = productApiClient.getProductDetail(2L);

        System.out.println("productDetail1 = " + productDetail1);
        System.out.println("productDetail2 = " + productDetail2);

        assertEquals(1L, productDetail1.getProductId());
        assertEquals("Cheeseburger Solo", productDetail1.getProductName());

        assertEquals(2L, productDetail2.getProductId());
        assertEquals("Tunaburger Solo", productDetail2.getProductName());
    }
}
