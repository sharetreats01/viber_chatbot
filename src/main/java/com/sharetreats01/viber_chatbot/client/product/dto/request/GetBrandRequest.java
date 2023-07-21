package com.sharetreats01.viber_chatbot.client.product.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class GetBrandRequest {
    private String order = "popular";
    GetBrandRequest(String order) {
        this.order = order;
    }
    public GetBrandRequest() {
        this.order = "popoular";
    }
}
