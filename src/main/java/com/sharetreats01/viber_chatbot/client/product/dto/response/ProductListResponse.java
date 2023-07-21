package com.sharetreats01.viber_chatbot.client.product.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.client.product.dto.response.parameter.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponse {
    @JsonProperty("products")
    private List<Product> products;
}
