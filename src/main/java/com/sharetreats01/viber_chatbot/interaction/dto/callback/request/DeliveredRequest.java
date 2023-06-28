package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeliveredRequest extends CallbackRequest {
    @JsonProperty("user_id")
    private String userId;
}
