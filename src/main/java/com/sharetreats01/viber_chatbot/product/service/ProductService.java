package com.sharetreats01.viber_chatbot.product.service;


import com.sharetreats01.viber_chatbot.product.client.ProductApiClient;
import com.sharetreats01.viber_chatbot.product.dto.request.GetBrandRequest;
import com.sharetreats01.viber_chatbot.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.product.dto.response.BrandListResponse;
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

}
