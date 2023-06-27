package com.sharetreats01.viber_chatbot.viber.dto.response;

import com.sharetreats01.viber_chatbot.viber.enums.Status;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ViberResponse {
    private final Status status;
    private final String statusMessage;
}
