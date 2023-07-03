package com.sharetreats01.viber_chatbot.order.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.stream.Stream;
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

    @JsonProperty("receiver_name")
    private String receiverName;

    @JsonProperty("message")
    private String message;

    @JsonProperty("coupon_code")
    private String couponCode;

    @JsonProperty("purchase_time")
    private String purchaseTime;

    @JsonProperty("expire_date")
    private String expireDate;

    public String toPictureBodyString() {
        String text = String.format("%s\n*%s*\n\n",this.getProductName(), this.getBrandName())
            + String.format("From: %s \n\n", this.getReceiverName())
            + String.format("message: \"%s\" \n\n",this.getMessage())
            + String.format("Code:%s\nExpire date: %s\n",this.getCouponCode(), this.getExpireDate());
        return text;
    }

}