package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import lombok.Getter;

@Getter
public class CallbackRequest {
    private Event event;
    private Long timestamp;
    private Long messageToken;
}
