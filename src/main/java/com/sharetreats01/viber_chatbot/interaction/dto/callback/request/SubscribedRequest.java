package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubscribedRequest extends CallbackRequest {
    @Delegate
    private User user;
}
