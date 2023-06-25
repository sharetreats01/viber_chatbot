package com.sharetreats01.viber_chatbot.product.dto.response.parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;

    private String name;

    private Long brandId;

    private String brandName;

    private String priceFormatted;

    private String imgUrl;
}
