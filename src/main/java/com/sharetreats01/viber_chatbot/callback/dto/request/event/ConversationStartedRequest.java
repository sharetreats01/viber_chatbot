package com.sharetreats01.viber_chatbot.callback.dto.request.event;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.User;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConversationStartedRequest extends CallbackRequest {
    private String type;
    private String context;
    private User user;
    private Boolean subscribed;
}
