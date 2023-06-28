package com.sharetreats01.viber_chatbot.order.dto.response;

import lombok.*;

import java.time.LocalDateTime;

/**
 * ORDER API 호출 시, 받는 코드
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderSuccessResponse {

    private Long orderId;
    private String brandName;
    private String productName;
    private String participatingUrl;
    private String giverName;
    private String message;
    private String couponCode;
    private String purchaseTime;
    private String expireDate;

}