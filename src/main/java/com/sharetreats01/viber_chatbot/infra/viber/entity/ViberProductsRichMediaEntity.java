package com.sharetreats01.viber_chatbot.infra.viber.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "tb_viber_products_rich_media")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ViberProductsRichMediaEntity {
    @Id
    public Integer id;

    @Column(name = "brand", length = 50, nullable = false)
    private String brand;

    @Column(name = "brand_desc", nullable = false, length = 50)
    private String brandDesc;

    @Column(name = "data", columnDefinition = "TEXT", nullable = false)
    private String data;
}
