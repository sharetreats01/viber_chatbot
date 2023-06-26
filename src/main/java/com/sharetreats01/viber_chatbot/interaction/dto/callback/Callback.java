package com.sharetreats01.viber_chatbot.interaction.dto.callback;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Sender;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.UserDto;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Callback {
    private Event event;
    private Long timestamp;
    private Long messageToken;
    private String type;
    private String context;
    private UserDto userDto;
    private Boolean subscribed;
    private String user_id;
    private String desc;
    private Sender sender;
    private com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Message message;

    public SubscribedDto buildSubscribed() {
        return new SubscribedDto(event, timestamp, userDto, messageToken);
    }

    public Unsubscribed buildUnsubscribed() {
        return new Unsubscribed(event, timestamp, user_id, messageToken);
    }

    public ConversationStartedDto buildConversationStarted() {
        return new ConversationStartedDto(event, timestamp, messageToken, type, context, userDto, subscribed);
    }

    public Delivered buildDelivered() {
        return new Delivered(event, timestamp, messageToken, user_id);
    }

    public Seen buildSeen() {
        return new Seen(event, timestamp, messageToken, user_id);
    }

    public Failed buildFailed() {
        return new Failed(event, timestamp, messageToken, user_id, desc);
    }

    public Message buildMessage() {
        return new Message(event, timestamp, messageToken, sender, message);
    }
}
