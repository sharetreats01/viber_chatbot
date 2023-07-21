package com.sharetreats01.viber_chatbot.client.product.client;

import com.sharetreats01.viber_chatbot.client.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.client.product.dto.response.BrandListResponse;
import com.sharetreats01.viber_chatbot.client.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.client.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.client.product.dto.request.GetBrandRequest;

public interface ProductApiClient {
    AvailablePaymentsResponse getPaymentList(Long productId);
    BrandListResponse getBrandList(GetBrandRequest request);

    ProductListResponse getProductsList(String brandName);

    ProductDetailResponse getProductDetail(Long productId);
}
