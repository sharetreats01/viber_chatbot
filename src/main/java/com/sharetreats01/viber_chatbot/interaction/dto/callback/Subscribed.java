package com.sharetreats01.viber_chatbot.interaction.dto.callback;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.UserDto;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Subscribed {
    private final Event event;
    private final long timeStamp;
    private final UserDto userDto;
    private final long messageToken;
}
