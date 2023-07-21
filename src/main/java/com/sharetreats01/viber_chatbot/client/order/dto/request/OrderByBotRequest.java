package com.sharetreats01.viber_chatbot.client.order.dto.request;

import lombok.*;

/**
 * 봇으로 주문 요청 시 필요한 DTO
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderByBotRequest {

    private String viberId;

    private String productId;

    private String paymentId;

    private String promoCode;

    private String giverPhone;

    private String giverName;

    private String receiverPhone;

    private String receiverName;

    private String message;

    private String email;


    public void setPromoCode(String code) {
        this.promoCode = code;
    }
}
