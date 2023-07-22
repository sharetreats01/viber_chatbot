package com.sharetreats01.viber_chatbot.botMessage.callback;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.User;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class UserFactory {
    private static final Field ID = ReflectionUtils.findField(User.class, "id");
    private static final Field NAME = ReflectionUtils.findField(User.class, "name");
    private static final Field AVATAR = ReflectionUtils.findField(User.class, "avatar");
    private static final Field COUNTRY = ReflectionUtils.findField(User.class, "country");
    private static final Field LANGUAGE = ReflectionUtils.findField(User.class, "language");
    private static final Field API_VERSION = ReflectionUtils.findField(User.class, "apiVersion");

    static {
        ID.setAccessible(true);
        NAME.setAccessible(true);
        AVATAR.setAccessible(true);
        COUNTRY.setAccessible(true);
        LANGUAGE.setAccessible(true);
        API_VERSION.setAccessible(true);
    }

    public static User createUserDto(String id, String name, String avatar, String country, String language, int apiVersion) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<User> constructor = ReflectionUtils.accessibleConstructor(User.class);
        User user = constructor.newInstance();
        ReflectionUtils.setField(ID, user, id);
        ReflectionUtils.setField(NAME, user, name);
        ReflectionUtils.setField(AVATAR, user, avatar);
        ReflectionUtils.setField(COUNTRY, user, country);
        ReflectionUtils.setField(LANGUAGE, user, language);
        ReflectionUtils.setField(API_VERSION, user, apiVersion);

        return user;
    }
}
