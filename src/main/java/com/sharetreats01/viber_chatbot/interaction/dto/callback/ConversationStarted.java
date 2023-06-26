package com.sharetreats01.viber_chatbot.interaction.dto.callback;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.User;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import lombok.*;

@Builder
@Getter
@RequiredArgsConstructor
public class ConversationStarted {
    private final Event event;
    private final Long timestamp;
    private final Long messageToken;
    private final String type;
    private final String context;
    private final User user;
    private final Boolean subscribed;
}
