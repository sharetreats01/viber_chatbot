package com.sharetreats01.viber_chatbot.client.product.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetProductListRequest {
    private String brand;
}
