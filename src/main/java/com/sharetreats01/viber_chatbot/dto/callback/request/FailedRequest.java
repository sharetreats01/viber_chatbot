package com.sharetreats01.viber_chatbot.dto.callback.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FailedRequest extends CallbackRequest {
    private String userId;
    private String desc;
}
