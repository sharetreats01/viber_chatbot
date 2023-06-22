package com.sharetreats01.viber_chatbot.interaction.dto.callback;

import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Unsubscribed {
    private final Event event;
    private final long timeStamp;
    private final String userId;
    private final long messageToken;
}
