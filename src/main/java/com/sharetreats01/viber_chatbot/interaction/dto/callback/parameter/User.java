package com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter;

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
    private Integer apiVersion;

}
