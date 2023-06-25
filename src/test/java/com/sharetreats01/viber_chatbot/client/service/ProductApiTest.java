package com.sharetreats01.viber_chatbot.client.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sharetreats01.viber_chatbot.product.dto.response.ProductDetail;
import com.sharetreats01.viber_chatbot.product.dto.response.ProductList;
import java.util.Map;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class ProductApiTest {
    @Test
    public void testGetProductDetail() {
        ProductApiClient productClient = new ProductApiClient();
        ProductDetail productDetail = productClient.getProductDetail();
        System.out.println(productDetail);
        assertEquals(1L, productDetail.getProductId());
        assertEquals("Cheeseburger Solo", productDetail.getProductName());
    }

    @Test
    public void testGetProductList() {
        ProductApiClient productClient = new ProductApiClient();
        ProductList productList = productClient.getProducts();
        assertEquals("Cheeseburger Solo", productList.getProducts().get(0).getName());
        assertEquals(1L, productList.getProducts().get(0).getId());
    }
}
