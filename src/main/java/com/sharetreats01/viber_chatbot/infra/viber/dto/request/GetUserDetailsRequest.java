package com.sharetreats01.viber_chatbot.infra.viber.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetUserDetailsRequest {
    private final String id;

    @Override
    public String toString() {
        return "GetUserDetailsRequest{" +
                "id='" + id + '\'' +
                '}';
    }
}
