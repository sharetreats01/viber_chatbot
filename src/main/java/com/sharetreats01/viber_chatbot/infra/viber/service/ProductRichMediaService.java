package com.sharetreats01.viber_chatbot.infra.viber.service;

import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.property.Keyboard;

public interface ProductRichMediaService {
    Keyboard getProductDetailRichMedia(ProductDetailResponse productDetail);
    Keyboard getProductsRichMedia(ProductListResponse productsList);
}
