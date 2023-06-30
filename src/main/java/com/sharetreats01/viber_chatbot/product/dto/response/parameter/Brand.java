package com.sharetreats01.viber_chatbot.product.dto.response.parameter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    private Long id;

    private String name;

    @JsonProperty("img_url")
    private String imgUrl;
}
