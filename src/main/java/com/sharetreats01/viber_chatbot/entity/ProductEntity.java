package com.sharetreats01.viber_chatbot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private BrandEntity brand;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductTypeEntity productType;

    @Column
    private String name;

    @Column(name ="image_url")
    private String imageURL;

    @Column
    private int price;

    @Column
    private String description;
}