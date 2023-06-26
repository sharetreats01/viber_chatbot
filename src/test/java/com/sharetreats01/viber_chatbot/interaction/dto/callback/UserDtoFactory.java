package com.sharetreats01.viber_chatbot.interaction.dto.callback;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.UserDto;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class UserDtoFactory {
    private static final Field ID = ReflectionUtils.findField(UserDto.class, "id");
    private static final Field NAME = ReflectionUtils.findField(UserDto.class, "name");
    private static final Field AVATAR = ReflectionUtils.findField(UserDto.class, "avatar");
    private static final Field COUNTRY = ReflectionUtils.findField(UserDto.class, "country");
    private static final Field LANGUAGE = ReflectionUtils.findField(UserDto.class, "language");
    private static final Field API_VERSION = ReflectionUtils.findField(UserDto.class, "apiVersion");

    static {
        ID.setAccessible(true);
        NAME.setAccessible(true);
        AVATAR.setAccessible(true);
        COUNTRY.setAccessible(true);
        LANGUAGE.setAccessible(true);
        API_VERSION.setAccessible(true);
    }

    public static UserDto createUserDto(String id, String name, String avatar, String country, String language, int apiVersion) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<UserDto> constructor = ReflectionUtils.accessibleConstructor(UserDto.class);
        UserDto userDto = constructor.newInstance();
        ReflectionUtils.setField(ID, userDto, id);
        ReflectionUtils.setField(NAME, userDto, name);
        ReflectionUtils.setField(AVATAR, userDto, avatar);
        ReflectionUtils.setField(COUNTRY, userDto, country);
        ReflectionUtils.setField(LANGUAGE, userDto, language);
        ReflectionUtils.setField(API_VERSION, userDto, apiVersion);

        return userDto;
    }
}
