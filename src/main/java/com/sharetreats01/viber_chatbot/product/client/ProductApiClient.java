package com.sharetreats01.viber_chatbot.product.client;

import com.sharetreats01.viber_chatbot.product.dto.request.GetBrandRequest;
import com.sharetreats01.viber_chatbot.product.dto.request.GetProductDetailRequest;
import com.sharetreats01.viber_chatbot.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.product.dto.response.BrandListResponse;
import com.sharetreats01.viber_chatbot.product.dto.response.ProductDetailResponse;

public interface ProductApiClient {
    AvailablePaymentsResponse getPaymentList(Long productId);

    BrandListResponse getBrandList(GetBrandRequest request);

    ProductDetailResponse getProductDetail(GetProductDetailRequest request);
}
