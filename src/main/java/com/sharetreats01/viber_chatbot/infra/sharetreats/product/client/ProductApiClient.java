package com.sharetreats01.viber_chatbot.infra.sharetreats.product.client;

import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.request.GetProductDetailRequest;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.BrandListResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.request.GetBrandRequest;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.request.GetProductListRequest;

public interface ProductApiClient {
    AvailablePaymentsResponse getPaymentList(Long productId);
    BrandListResponse getBrandList(GetBrandRequest request);

    ProductListResponse getProductsList(GetProductListRequest request);

    ProductDetailResponse getProductDetail(Long productId);
}
