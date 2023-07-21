package com.sharetreats01.viber_chatbot.client.product.dto.response.parameter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;

    private String name;

    @JsonProperty("brand_id")
    private Long brandId;

    @JsonProperty("brand_name")
    private String brandName;

    @JsonProperty("price_formmated")
    private String priceFormatted;

    @JsonProperty("img_url")
    private String imgUrl;
}
