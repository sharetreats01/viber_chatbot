package com.sharetreats01.viber_chatbot.product.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailResponse {

    @JsonProperty("brand_id")
    private Long brandId;

    @JsonProperty("brand_name")
    private String brandName;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("origin_price")
    private String originPrice;

    @JsonProperty("description")
    private String description;

    @JsonProperty("participation_url")
    private String participationUrl;
}
