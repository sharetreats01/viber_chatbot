package com.sharetreats01.viber_chatbot.order.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {

    private Long productId;

    private String productName;

    private List<ProductPaymentCase> payments;

}
