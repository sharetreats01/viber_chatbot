package com.sharetreats01.viber_chatbot.client.product.service;


import com.sharetreats01.viber_chatbot.client.product.client.ProductApiClient;
import com.sharetreats01.viber_chatbot.client.product.dto.request.GetBrandRequest;
import com.sharetreats01.viber_chatbot.client.product.dto.response.BrandListResponse;
import com.sharetreats01.viber_chatbot.client.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.client.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.client.product.dto.response.AvailablePaymentsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductApiClient productApiClient;

    public AvailablePaymentsResponse getPaymentList(String productIdStr) {
        Long productId = Long.parseLong(productIdStr,10);
        return productApiClient.getPaymentList(productId);
    }

    public BrandListResponse getBrandList(GetBrandRequest request){
        return productApiClient.getBrandList(request);
    }

    public ProductListResponse getProducts(Long brandId) {
        return productApiClient.getProductsList(brandId);
    }

    public ProductDetailResponse getProductDetail(Long productId) {
        return productApiClient.getProductDetail(productId);
    }
}
