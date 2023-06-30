package com.sharetreats01.viber_chatbot.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private String id;
    private String name;
    private String avatar;
    private String country;
    private String language;
    @JsonProperty("primary_device_os")
    private String primaryDeviceOs;
    @JsonProperty("api_version")
    private Integer apiVersion;
    @JsonProperty("viber_version")
    private String viberVersion;
    private Integer mcc;
    private Integer mnc;
    @JsonProperty("device_type")
    private String deviceType;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                ", primaryDeviceOs='" + primaryDeviceOs + '\'' +
                ", apiVersion=" + apiVersion +
                ", viberVersion='" + viberVersion + '\'' +
                ", mcc=" + mcc +
                ", mnc=" + mnc +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }
}
