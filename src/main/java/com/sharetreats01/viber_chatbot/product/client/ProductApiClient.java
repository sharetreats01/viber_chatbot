package com.sharetreats01.viber_chatbot.product.client;

import com.sharetreats01.viber_chatbot.product.dto.request.GetBrandRequest;
import com.sharetreats01.viber_chatbot.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.product.dto.response.BrandListResponse;

public interface ProductApiClient {
    AvailablePaymentsResponse getPaymentList(Long productId);
    BrandListResponse getBrandList(GetBrandRequest request);
}
