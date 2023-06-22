package com.sharetreats01.viber_chatbot.order.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * product별 payment 호출시 받는 DTO
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPaymentCase {

    private Long paymentId;

    private String paymentName;

    private String imgUrl;

    private String origin_price;

    private String sale_price;
}
