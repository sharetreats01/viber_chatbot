package com.sharetreats01.viber_chatbot.interaction.dto.callback;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Sender;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.User;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Callback {
    private final Event event;
    private final Long timestamp;
    private final Long messageToken;
    private final String type;
    private final String context;
    private final User user;
    private final Boolean subscribed;
    private final String user_id;
    private final String desc;
    private final Sender sender;
    private final com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Message message;

    public Subscribed buildSubscribed() {
        return new Subscribed(event, timestamp, user, messageToken);
    }

    public Unsubscribed buildUnsubscribed() {
        return new Unsubscribed(event, timestamp, user_id, messageToken);
    }

    public ConversationStarted buildConversationStarted() {
        return new ConversationStarted(event, timestamp, messageToken, type, context, user, subscribed);
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
