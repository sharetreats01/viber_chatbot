package com.sharetreats01.viber_chatbot.infra.sharetreats.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "brand")
public class BrandEntity {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name= "image_url")
    private String imageURL;

    @Column(name= "description")
    private String description;
}