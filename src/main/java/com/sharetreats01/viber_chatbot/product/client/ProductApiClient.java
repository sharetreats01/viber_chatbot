package com.sharetreats01.viber_chatbot.product.client;

import com.sharetreats01.viber_chatbot.product.dto.request.GetBrandRequest;
import com.sharetreats01.viber_chatbot.product.dto.request.GetProductDetailRequest;
import com.sharetreats01.viber_chatbot.product.dto.request.GetProductListRequest;
import com.sharetreats01.viber_chatbot.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.product.dto.response.BrandListResponse;
import com.sharetreats01.viber_chatbot.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.product.dto.response.ProductListResponse;

public interface ProductApiClient {
    AvailablePaymentsResponse getPaymentList(Long productId);
    BrandListResponse getBrandList(GetBrandRequest request);

    ProductListResponse getProductsList(GetProductListRequest request);

    ProductDetailResponse getProductDetail(GetProductDetailRequest request);
}
