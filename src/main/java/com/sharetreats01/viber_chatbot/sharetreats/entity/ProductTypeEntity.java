package com.sharetreats01.viber_chatbot.sharetreats.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_type")
public class ProductTypeEntity {
    @Id
    private Long id;

    @Column
    private String name;
}