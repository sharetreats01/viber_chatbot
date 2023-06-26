package com.sharetreats01.viber_chatbot.product.service;

import com.sharetreats01.viber_chatbot.client.service.ProductApiClient;
import com.sharetreats01.viber_chatbot.product.dto.response.BrandList;
import com.sharetreats01.viber_chatbot.product.dto.response.ProductDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private ProductApiClient productApiClient;
    public BrandList getProductListByBrand(String BrandName) {
        return productApiClient.getBrandList();
    }

    public ProductDetail getProductDetail(String productId) {
        return productApiClient.getProductDetail();
    }

    public void getAvailablePayments() {

    }
}
