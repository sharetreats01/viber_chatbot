package com.sharetreats01.viber_chatbot.dto.callback.request;

import com.sharetreats01.viber_chatbot.dto.callback.request.property.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubscribedRequest extends CallbackRequest {
    private User user;
}
