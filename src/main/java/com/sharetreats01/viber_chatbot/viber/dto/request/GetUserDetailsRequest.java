package com.sharetreats01.viber_chatbot.viber.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetUserDetailsRequest {
    private final String id;
}
