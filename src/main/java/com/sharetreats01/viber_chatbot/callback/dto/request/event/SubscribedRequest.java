package com.sharetreats01.viber_chatbot.callback.dto.request.event;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubscribedRequest extends MessageRequest{
    private User user;
}
