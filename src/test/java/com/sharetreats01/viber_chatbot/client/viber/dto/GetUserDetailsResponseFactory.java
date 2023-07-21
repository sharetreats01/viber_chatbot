package com.sharetreats01.viber_chatbot.client.viber.dto;

import com.sharetreats01.viber_chatbot.user.dto.User;
import com.sharetreats01.viber_chatbot.user.dto.UserFactory;
import com.sharetreats01.viber_chatbot.client.viber.dto.response.GetUserDetailsResponse;
import com.sharetreats01.viber_chatbot.client.viber.enums.Status;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class GetUserDetailsResponseFactory {
    public static final Field STATUS = ReflectionUtils.findField(GetUserDetailsResponse.class, "status", Status.class);
    public static final Field STATUS_MESSAGE = ReflectionUtils.findField(GetUserDetailsResponse.class, "statusMessage", String.class);
    public static final Field MESSAGE_TOKEN = ReflectionUtils.findField(GetUserDetailsResponse.class, "messageToken", Long.class);
    public static final Field USER = ReflectionUtils.findField(GetUserDetailsResponse.class, "user", User.class);
    public static final Constructor<GetUserDetailsResponse> constructor;

    static {
        try {
            constructor = ReflectionUtils.accessibleConstructor(GetUserDetailsResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        STATUS.setAccessible(true);
        STATUS_MESSAGE.setAccessible(true);
        MESSAGE_TOKEN.setAccessible(true);
        USER.setAccessible(true);
    }

    public static GetUserDetailsResponse create() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return create(Status.OK, "ok", 4912661846655238145L, UserFactory.create());
    }

    public static GetUserDetailsResponse create(Status status, String statusMessage, Long messageToken, User user) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        GetUserDetailsResponse getUserDetailsResponse = constructor.newInstance();
        ReflectionUtils.setField(STATUS, getUserDetailsResponse, status);
        ReflectionUtils.setField(STATUS_MESSAGE, getUserDetailsResponse, statusMessage);
        ReflectionUtils.setField(MESSAGE_TOKEN, getUserDetailsResponse, messageToken);
        ReflectionUtils.setField(USER, getUserDetailsResponse, user);
        return getUserDetailsResponse;
    }
}
