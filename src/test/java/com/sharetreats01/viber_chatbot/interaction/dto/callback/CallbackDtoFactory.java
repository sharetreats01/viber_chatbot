package com.sharetreats01.viber_chatbot.interaction.dto.callback;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.User;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CallbackDtoFactory {
    private static final Field EVENT = ReflectionUtils.findField(Callback.class, "event");
    private static final Field TIMESTAMP = ReflectionUtils.findField(Callback.class, "timestamp");
    private static final Field MESSAGE_TOKEN = ReflectionUtils.findField(Callback.class, "messageToken");
    private static final Field TYPE = ReflectionUtils.findField(Callback.class, "type");
    private static final Field CONTEXT = ReflectionUtils.findField(Callback.class, "context");
    private static final Field USER_DTO = ReflectionUtils.findField(Callback.class, "user");
    private static final Field SUBSCRIBED = ReflectionUtils.findField(Callback.class, "subscribed");
    private static final Field USER_ID = ReflectionUtils.findField(Callback.class, "user_id");
    private static final Field DESC = ReflectionUtils.findField(Callback.class, "desc");
    private static final Field SEND = ReflectionUtils.findField(Callback.class, "sender");
    private static final Field MESSAGE = ReflectionUtils.findField(Callback.class, "message");
    private static final Constructor<Callback> constructor;

    static {
        try {
            constructor = ReflectionUtils.accessibleConstructor(Callback.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        EVENT.setAccessible(true);
        TIMESTAMP.setAccessible(true);
        MESSAGE_TOKEN.setAccessible(true);
        TYPE.setAccessible(true);
        CONTEXT.setAccessible(true);
        USER_DTO.setAccessible(true);
        SUBSCRIBED.setAccessible(true);
        USER_ID.setAccessible(true);
        DESC.setAccessible(true);
        SEND.setAccessible(true);
        MESSAGE.setAccessible(true);
    }

    public static Callback createConversationDto(Event event, Long timeStamp, Long messageToken, String type, String context, User user, boolean subscribed) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Callback callback = constructor.newInstance();
        ReflectionUtils.setField(EVENT, callback, event);
        ReflectionUtils.setField(TIMESTAMP, callback, timeStamp);
        ReflectionUtils.setField(MESSAGE_TOKEN, callback, messageToken);
        ReflectionUtils.setField(TYPE, callback, type);
        ReflectionUtils.setField(CONTEXT, callback, context);
        ReflectionUtils.setField(USER_DTO, callback, user);
        ReflectionUtils.setField(SUBSCRIBED, callback, subscribed);
        return callback;
    }

    public static Callback createSubscribed(Event event, Long timeStamp, User user, Long messageToken) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Callback callback = constructor.newInstance();
        ReflectionUtils.setField(EVENT, callback, event);
        ReflectionUtils.setField(TIMESTAMP, callback, timeStamp);
        ReflectionUtils.setField(USER_DTO, callback, user);
        ReflectionUtils.setField(MESSAGE_TOKEN, callback, messageToken);
        return callback;
    }
}
