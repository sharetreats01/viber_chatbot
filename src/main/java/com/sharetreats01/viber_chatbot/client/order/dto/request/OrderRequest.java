package com.sharetreats01.viber_chatbot.client.order.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderRequest {
    private String productId;

    private String discountCode;

    private String paymentTypeId;

    private String giverPhone;

    private String giverName;

    private String receiverPhone;

    private String receiverName;

    private String message;

    private String email;

    public static OrderRequest botOrderRequestToOrderRequest (OrderByBotRequest botOrderRequest) {
        return OrderRequest.builder()
                .productId(botOrderRequest.getProductId())
                .discountCode(botOrderRequest.getPromoCode())
                .paymentTypeId(botOrderRequest.getPaymentId())
                .giverPhone(botOrderRequest.getGiverPhone())
                .giverName(botOrderRequest.getGiverName())
                .receiverPhone(botOrderRequest.getReceiverPhone())
                .receiverName(botOrderRequest.getReceiverName())
                .message(botOrderRequest.getMessage())
                .email(botOrderRequest.getEmail())
                .build();
    }
}
