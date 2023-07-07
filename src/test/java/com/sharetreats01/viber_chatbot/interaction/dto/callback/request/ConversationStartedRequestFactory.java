package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import com.sharetreats01.viber_chatbot.dto.callback.request.ConversationStartedRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.User;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ConversationStartedRequestFactory {
    private static final Field TIMESTAMP = ReflectionUtils.findField(ConversationStartedRequest.class, "timestamp");
    private static final Field MESSAGE_TOKEN = ReflectionUtils.findField(ConversationStartedRequest.class, "messageToken");
    private static final Field TYPE = ReflectionUtils.findField(ConversationStartedRequest.class, "type");
    private static final Field CONTEXT = ReflectionUtils.findField(ConversationStartedRequest.class, "context");
    private static final Field USER = ReflectionUtils.findField(ConversationStartedRequest.class, "user");
    private static final Field SUBSCRIBED = ReflectionUtils.findField(ConversationStartedRequest.class, "subscribed");

    static {

        TIMESTAMP.setAccessible(true);
        MESSAGE_TOKEN.setAccessible(true);
        TYPE.setAccessible(true);
        CONTEXT.setAccessible(true);
        USER.setAccessible(true);
        SUBSCRIBED.setAccessible(true);
    }

    private static final Constructor<ConversationStartedRequest> CONSTRUCTOR;

    static {
        try {
            CONSTRUCTOR = ReflectionUtils.accessibleConstructor(ConversationStartedRequest.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

    protected static ConversationStartedRequest createConversationRequest(Long timeStamp, Long messageToken, String type, String context, User user, boolean subscribed) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        ConversationStartedRequest request = CONSTRUCTOR.newInstance();
        ReflectionUtils.setField(TIMESTAMP, request, timeStamp);
        ReflectionUtils.setField(MESSAGE_TOKEN, request, messageToken);
        ReflectionUtils.setField(TYPE, request, type);
        ReflectionUtils.setField(CONTEXT, request, context);
        ReflectionUtils.setField(USER, request, user);
        ReflectionUtils.setField(SUBSCRIBED, request, subscribed);
        return request;
    }
}
