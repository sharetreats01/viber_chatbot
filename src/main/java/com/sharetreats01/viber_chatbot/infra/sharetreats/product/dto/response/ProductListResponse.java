package com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.parameter.Product;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductListResponse {
    @JsonProperty("products")
    private List<Product> products;
}
