package com.sharetreats01.viber_chatbot.sharetreats.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tb_sharetreats_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ShareTreatsProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    @ToString.Exclude
    private ShareTreatsBrandEntity brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private ShareTreatsCategoryEntity category;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "product_desc", length = 50)
    private String productDesc;

    @Column(name = "expiration", length = 50, nullable = false)
    private String expiration;

    public void setCategory(ShareTreatsCategoryEntity category) {
        this.category = category;
    }

    public void setBrand(ShareTreatsBrandEntity brand) {
        this.brand = brand;
    }

    public ShareTreatsProductEntity(ShareTreatsBrandEntity brand, ShareTreatsCategoryEntity category, String productName, Integer amount, Integer stock, String productDesc, String expiration) {
        this.brand = brand;
        this.category = category;
        this.productName = productName;
        this.amount = amount;
        this.stock = stock;
        this.productDesc = productDesc;
        this.expiration = expiration;
    }
}
