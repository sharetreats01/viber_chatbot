package com.sharetreats01.viber_chatbot.user.entity;

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
    private Integer apiVersion;

    @Column(name = "is_subscribe")
    private Boolean isSubscribe;

    public void unsubscribe() {
        this.isSubscribe = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity entity = (UserEntity) o;

        if (!id.equals(entity.id)) return false;
        if (!name.equals(entity.name)) return false;
        if (!avatar.equals(entity.avatar)) return false;
        if (!country.equals(entity.country)) return false;
        if (!language.equals(entity.language)) return false;
        if (!apiVersion.equals(entity.apiVersion)) return false;
        return isSubscribe.equals(entity.isSubscribe);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + avatar.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + apiVersion.hashCode();
        result = 31 * result + isSubscribe.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity entity = (UserEntity) o;

        if (!id.equals(entity.id)) return false;
        if (!name.equals(entity.name)) return false;
        if (!avatar.equals(entity.avatar)) return false;
        if (!country.equals(entity.country)) return false;
        if (!language.equals(entity.language)) return false;
        if (!apiVersion.equals(entity.apiVersion)) return false;
        return isSubscribe.equals(entity.isSubscribe);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + avatar.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + apiVersion.hashCode();
        result = 31 * result + isSubscribe.hashCode();
        return result;
    }
}
