package com.sharetreats01.viber_chatbot.interaction.dto.callback;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.UserDto;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ConversationStartedDto {
    private final Event event;
    private final Long timestamp;
    private final Long messageToken;
    private final String type;
    private final String context;
    private final UserDto userDto;
    private final Boolean subscribed;
}
