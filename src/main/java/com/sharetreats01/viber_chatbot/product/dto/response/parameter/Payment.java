package com.sharetreats01.viber_chatbot.product.dto.response.parameter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long id;

    private String name;

    @JsonProperty("icon_url")
    private String iconUrl;

    @JsonProperty("origin_price")
    private String originPrice;

    @JsonProperty("discount_price")
    private String discountPrice;
}
