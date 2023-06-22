package com.sharetreats01.viber_chatbot.interaction.dto.callback;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Sender;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Message {
    private final Event event;
    private final long timeStamp;
    private final long messageToken;
    private final Sender sender;
    private final com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Message message;
}
