package com.sharetreats01.viber_chatbot.infra.sharetreats.product.service;


import com.sharetreats01.viber_chatbot.infra.sharetreats.product.client.ProductApiClient;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.request.GetBrandRequest;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.BrandListResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductListResponse;
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

    public ProductListResponse getProducts(String brandName) {
        return productApiClient.getProductsList(brandName);
    }

    public ProductDetailResponse getProductDetail(Long productId) {
        return productApiClient.getProductDetail(productId);
    }
}
