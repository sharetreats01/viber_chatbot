package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.User;

import java.lang.reflect.InvocationTargetException;

public class CallbackRequestFactory {
    public static ConversationStartedRequest createConversationRequest(Long timeStamp, Long messageToken, String type, String context, User user, boolean subscribed) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return ConversationStartedRequestFactory.createConversationRequest(timeStamp, messageToken, type, context, user, subscribed);
    }

    public static SubscribedRequest createSubscribedRequest(Long timeStamp, User user, Long messageToken) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return SubscribeRequestFactory.createSubscribedRequest(timeStamp, user, messageToken);
    }
}
