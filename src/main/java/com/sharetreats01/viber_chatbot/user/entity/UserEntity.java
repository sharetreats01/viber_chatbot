package com.sharetreats01.viber_chatbot.user.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Entity
@Table(name = "tb_user")
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

    @Column(name = "primary_device_os", length = 20)
    private String primaryDeviceOs;

    @Column(name = "viber_version", length = 20)
    private String viberVersion;

    @Column(name = "device_type", length = 20)
    private String deviceType;

    @Column(name = "mobile_country_code", length = 2)
    private Integer mobileCountryCode;

    @Column(name = "mobile_network_code", length = 2)
    private Integer mobileNetworkCode;

    @Column(name = "is_subscribe")
    private Boolean isSubscribe;

    public UserEntity(String id, String name, String avatar, String country, String language, Integer apiVersion, String primaryDeviceOs, String viberVersion, String deviceType, Integer mobileCountryCode, Integer mobileNetworkCode) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.country = country;
        this.language = language;
        this.apiVersion = apiVersion;
        this.primaryDeviceOs = primaryDeviceOs;
        this.viberVersion = viberVersion;
        this.deviceType = deviceType;
        this.mobileCountryCode = mobileCountryCode;
        this.mobileNetworkCode = mobileNetworkCode;
    }

    public void subscribe() {
        this.isSubscribe = true;
    }

    public void unsubscribe() {
        this.isSubscribe = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity entity = (UserEntity) o;

        if (!id.equals(entity.id)) return false;
        if (!Objects.equals(name, entity.name)) return false;
        if (!Objects.equals(avatar, entity.avatar)) return false;
        if (!Objects.equals(country, entity.country)) return false;
        if (!Objects.equals(language, entity.language)) return false;
        if (!Objects.equals(apiVersion, entity.apiVersion)) return false;
        if (!Objects.equals(isSubscribe, entity.isSubscribe)) return false;
        if (!Objects.equals(primaryDeviceOs, entity.primaryDeviceOs))
            return false;
        if (!Objects.equals(viberVersion, entity.viberVersion))
            return false;
        if (!Objects.equals(deviceType, entity.deviceType)) return false;
        if (!Objects.equals(mobileCountryCode, entity.mobileCountryCode))
            return false;
        return Objects.equals(mobileNetworkCode, entity.mobileNetworkCode);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (apiVersion != null ? apiVersion.hashCode() : 0);
        result = 31 * result + (isSubscribe != null ? isSubscribe.hashCode() : 0);
        result = 31 * result + (primaryDeviceOs != null ? primaryDeviceOs.hashCode() : 0);
        result = 31 * result + (viberVersion != null ? viberVersion.hashCode() : 0);
        result = 31 * result + (deviceType != null ? deviceType.hashCode() : 0);
        result = 31 * result + (mobileCountryCode != null ? mobileCountryCode.hashCode() : 0);
        result = 31 * result + (mobileNetworkCode != null ? mobileNetworkCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                ", apiVersion=" + apiVersion +
                ", isSubscribe=" + isSubscribe +
                ", primaryDeviceOs='" + primaryDeviceOs + '\'' +
                ", viberVersion='" + viberVersion + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", mobileCountryCode=" + mobileCountryCode +
                ", mobileNetworkCode=" + mobileNetworkCode +
                '}';
    }
}
