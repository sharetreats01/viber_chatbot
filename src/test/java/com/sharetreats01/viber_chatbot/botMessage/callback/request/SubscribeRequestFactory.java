package com.sharetreats01.viber_chatbot.botMessage.callback.request;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.SubscribedRequest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.User;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SubscribeRequestFactory {
    private static final Field TIMESTAMP = ReflectionUtils.findField(SubscribedRequest.class, "timestamp");
    private static final Field MESSAGE_TOKEN = ReflectionUtils.findField(SubscribedRequest.class, "messageToken");
    private static final Field USER = ReflectionUtils.findField(SubscribedRequest.class, "user");
    private static final Constructor<SubscribedRequest> constructor;

    static {
        try {
            constructor = ReflectionUtils.accessibleConstructor(SubscribedRequest.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        TIMESTAMP.setAccessible(true);
        MESSAGE_TOKEN.setAccessible(true);
        USER.setAccessible(true);
    }

    protected static SubscribedRequest createSubscribedRequest(Long timeStamp, User user, Long messageToken) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        SubscribedRequest request = constructor.newInstance();
        ReflectionUtils.setField(TIMESTAMP, request, timeStamp);
        ReflectionUtils.setField(USER, request, user);
        ReflectionUtils.setField(MESSAGE_TOKEN, request, messageToken);
        return request;
    }
}
