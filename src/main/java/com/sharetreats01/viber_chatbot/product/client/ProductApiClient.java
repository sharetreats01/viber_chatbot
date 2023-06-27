package com.sharetreats01.viber_chatbot.product.client;

public interface ProductApiClient {

    void getBrandList();
    void getProductListByBrandName();
    void getProductDetailById(String productId);
}
