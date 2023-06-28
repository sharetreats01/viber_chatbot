package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SeenRequest extends CallbackRequest {
    private String userId;
}
