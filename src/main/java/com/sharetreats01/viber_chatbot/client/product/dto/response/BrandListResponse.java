package com.sharetreats01.viber_chatbot.client.product.dto.response;

import com.sharetreats01.viber_chatbot.client.product.dto.response.parameter.Brand;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BrandListResponse {
    private List<Brand> brands;
}
