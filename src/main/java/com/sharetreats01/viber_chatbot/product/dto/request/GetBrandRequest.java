package com.sharetreats01.viber_chatbot.product.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class GetBrandRequest {
    private String order = "popular";
    GetBrandRequest(String order) {
        this.order = order;
    }
}
