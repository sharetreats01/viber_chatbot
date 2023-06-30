package com.sharetreats01.viber_chatbot.order.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

/**
 * ORDER API 호출 시, 받는 코드
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderSuccessResponse {

    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("brand_id")
    private String brandName;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_url")
    private String productUrl;

    @JsonProperty("participating_url")
    private String participatingUrl;

    @JsonProperty("giver_name")
    private String giverName;

    @JsonProperty("message")
    private String message;

    @JsonProperty("coupon_code")
    private String couponCode;

    @JsonProperty("purchase_time")
    private String purchaseTime;

    @JsonProperty("expire_date")
    private String expireDate;

}