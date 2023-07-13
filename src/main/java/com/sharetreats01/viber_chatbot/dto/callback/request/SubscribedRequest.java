package com.sharetreats01.viber_chatbot.dto.callback.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubscribedRequest extends MessageRequest{
    @JsonProperty("user")
    private User sender;
}
