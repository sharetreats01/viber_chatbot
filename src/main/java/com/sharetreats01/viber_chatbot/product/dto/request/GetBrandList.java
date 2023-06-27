package com.sharetreats01.viber_chatbot.product.dto.request;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Builder
public class GetBrandList {
    private String orderBy;
}
