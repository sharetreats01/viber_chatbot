package com.sharetreats01.viber_chatbot.order.entity;

import com.sharetreats01.viber_chatbot.order.status.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 통계 목적 봇 주문 이력 저장 테이블
 */
@Getter
@Setter
@Entity
@Table(name = "TB_ORDER_BOT")
@NoArgsConstructor
public class BotOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "product_name")
    private Long productName;

    @Column(name = "viber_id")
    private String viberId;

    @Column(name = "price")
    private Integer price;

    @Column(name = "giver_phone")
    private String giverPhone;

    @Column(name = "reciever_phone")
    private String receiverPhone;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public BotOrder(String brandName, Long productName, String viberId, Integer price,
                    String giverPhone, String receiverPhone, OrderStatus status)
    {
        this.brandName = brandName;
        this.productName = productName;
        this.viberId = viberId;
        this.price = price;
        this.giverPhone = giverPhone;
        this.receiverPhone = receiverPhone;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}