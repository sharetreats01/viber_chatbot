package com.sharetreats01.viber_chatbot.order.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private String viberId;

    private String productId;

    private String discountCode;

    private String paymentTypeId;

    private String price;

    private String giverPhone;

    private String giverName;

    private String receiverPhone;

    private String receiverName;

    private String message;

}
