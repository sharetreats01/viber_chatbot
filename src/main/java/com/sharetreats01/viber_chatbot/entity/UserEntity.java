package com.sharetreats01.viber_chatbot.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "country")
    private String country;

    @Column(name = "language")
    private String language;

    @Column(name = "api_version")
    private int apiVersion;
}
