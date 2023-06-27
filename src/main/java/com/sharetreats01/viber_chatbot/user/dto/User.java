package com.sharetreats01.viber_chatbot.user.dto;

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
    private String primaryDeviceOs;
    private Integer apiVersion;
    private String viberVersion;
    private Integer mcc;
    private Integer mnc;
    private String deviceType;
}
