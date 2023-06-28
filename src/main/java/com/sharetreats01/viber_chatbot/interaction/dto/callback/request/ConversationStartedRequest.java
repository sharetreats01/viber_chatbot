package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.User;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConversationStartedRequest extends CallbackRequest {
    private String type;
    private String context;
    private User user;
    private Boolean subscribed;
}
