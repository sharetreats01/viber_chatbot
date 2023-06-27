package com.sharetreats01.viber_chatbot.product.service;

import com.sharetreats01.viber_chatbot.product.client.ProductApiClientImpl;
import com.sharetreats01.viber_chatbot.product.dto.response.AvailablePayments;
import com.sharetreats01.viber_chatbot.product.dto.response.BrandList;
import com.sharetreats01.viber_chatbot.product.dto.response.ProductDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private ProductApiClientImpl productApiClient;
    public BrandList getProductListByBrand(String BrandName) {
        return productApiClient.getBrandList();
    }

    public ProductDetail getProductDetail(String productId) {
        return productApiClient.getProductDetail();
    }

    public AvailablePayments getAvailablePayments(String productId) {
        return productApiClient.getProductPayments(productId);
    }
}
