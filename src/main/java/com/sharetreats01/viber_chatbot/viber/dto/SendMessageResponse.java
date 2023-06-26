package com.sharetreats01.viber_chatbot.viber.dto;

import com.sharetreats01.viber_chatbot.viber.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SendMessageResponse {
    private Status status;
    private Status statusMessage;
    private String messageToken;
    private String chatHostname;
    private Integer billingStatus;
}
