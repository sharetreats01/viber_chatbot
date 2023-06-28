package com.sharetreats01.viber_chatbot.order.dto.request;

import lombok.*;

/**
 * 봇으로 주문 요청 시 필요한 DTO
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderByBotRequest {

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

    private String email;
}
