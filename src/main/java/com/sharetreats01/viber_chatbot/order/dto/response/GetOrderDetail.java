package com.sharetreats01.viber_chatbot.order.dto.response;

import lombok.*;

import java.time.LocalDateTime;

/**
 * ORDER API 호출 시, 받는 코드
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderDetail {

    private Long id;

    private Long userId;

    private Long brandId;

    private String brandName;

    private String productId;

    private Long productName;

    private String giverPhone;

    private String giverName;

    private String receiverPhone;

    private String receiverName;

    private String couponCode;

    private Integer price;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}