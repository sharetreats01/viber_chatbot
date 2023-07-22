package com.sharetreats01.viber_chatbot.botMessage.service.message;

import com.sharetreats01.viber_chatbot.client.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.client.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.property.Keyboard;

public interface ProductRichMediaService {
    Keyboard getProductDetailRichMedia(ProductDetailResponse productDetail);
    Keyboard getProductsRichMedia(ProductListResponse productsList);
}
