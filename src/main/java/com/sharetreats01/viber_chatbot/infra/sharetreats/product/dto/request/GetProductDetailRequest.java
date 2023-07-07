package com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetProductDetailRequest {
    private Long productId;
}
