package com.sharetreats01.viber_chatbot.product.dto.response.parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long id;
    private String name;
    private String iconUrl;
    private String originPrice;
    private String discountPrice;
}
