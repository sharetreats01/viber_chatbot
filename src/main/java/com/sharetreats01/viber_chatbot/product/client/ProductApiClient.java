package com.sharetreats01.viber_chatbot.product.client;

import com.sharetreats01.viber_chatbot.product.dto.response.AvailablePaymentsResponse;

public interface ProductApiClient {
    AvailablePaymentsResponse getPaymentList(Long productId);
}
