package com.sharetreats01.viber_chatbot.client.viber.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tb_viber_product_detail_rich_media")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ViberProductDetailRichMediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "data", columnDefinition = "TEXT")
    private String data;

    public ViberProductDetailRichMediaEntity(String brand, String productName, String data) {
        this.brand = brand;
        this.productName = productName;
        this.data = data;
    }
}
