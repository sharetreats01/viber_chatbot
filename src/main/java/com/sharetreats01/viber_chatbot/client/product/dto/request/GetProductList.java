package com.sharetreats01.viber_chatbot.client.product.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetProductList {
    private String brand;
}
