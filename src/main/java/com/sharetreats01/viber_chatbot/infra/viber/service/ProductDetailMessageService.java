package com.sharetreats01.viber_chatbot.infra.viber.service;

import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

@Service
public class ProductDetailMessageService {
    public String getProductDetailText(ProductDetailResponse productDetail) {
        String newline = "\n";

        StringJoiner text = new StringJoiner(newline);
        text.add(productDetail.getBrandName())
                .add(productDetail.getProductName())
                .add(productDetail.getOriginPrice() + " -> "
                        + productDetail.getDiscountPrice() + newline)
                .add(productDetail.getDescription());

        return text.toString();
    }
}
