package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubscribeRequest extends CallbackRequest {
    @Delegate
    private User user;
}
