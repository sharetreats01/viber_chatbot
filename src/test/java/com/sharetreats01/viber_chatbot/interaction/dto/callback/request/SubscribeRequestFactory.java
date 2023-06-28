package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SubscribeRequestFactory {
    private static final Field EVENT = ReflectionUtils.findField(SubscribeRequest.class, "event");
    private static final Field TIMESTAMP = ReflectionUtils.findField(SubscribeRequest.class, "timestamp");
    private static final Field MESSAGE_TOKEN = ReflectionUtils.findField(SubscribeRequest.class, "messageToken");
    private static final Field USER = ReflectionUtils.findField(SubscribeRequest.class, "user");
    private static final Constructor<SubscribeRequest> constructor;

    static {
        try {
            constructor = ReflectionUtils.accessibleConstructor(SubscribeRequest.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        EVENT.setAccessible(true);
        TIMESTAMP.setAccessible(true);
        MESSAGE_TOKEN.setAccessible(true);
        USER.setAccessible(true);
    }

    protected static SubscribeRequest createSubscribedRequest(Event event, Long timeStamp, User user, Long messageToken) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        SubscribeRequest request = constructor.newInstance();
        ReflectionUtils.setField(EVENT, request, event);
        ReflectionUtils.setField(TIMESTAMP, request, timeStamp);
        ReflectionUtils.setField(USER, request, user);
        ReflectionUtils.setField(MESSAGE_TOKEN, request, messageToken);
        return request;
    }
}
