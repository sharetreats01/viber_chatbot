package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import com.sharetreats01.viber_chatbot.interaction.enums.Event;

import java.lang.reflect.InvocationTargetException;

public class CallbackRequestFactory {
    public static ConversationStartedRequest createConversationRequest(Event event, Long timeStamp, Long messageToken, String type, String context, User user, boolean subscribed) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return ConversationStartedRequestFactory.createConversationRequest(event, timeStamp, messageToken, type, context, user, subscribed);
    }

    public static SubscribeRequest createSubscribedRequest(Event event, Long timeStamp, User user, Long messageToken) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return SubscribeRequestFactory.createSubscribedRequest(event, timeStamp, user, messageToken);
    }
}
