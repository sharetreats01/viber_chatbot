package com.sharetreats01.viber_chatbot.user.dto;


import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class UserFactory {
    public static Map<String, Field> fields = new HashMap<>() {{
        put("id", ReflectionUtils.findField(User.class, "id", String.class));
        put("name", ReflectionUtils.findField(User.class, "name", String.class));
        put("avatar", ReflectionUtils.findField(User.class, "avatar", String.class));
        put("country", ReflectionUtils.findField(User.class, "country", String.class));
        put("language", ReflectionUtils.findField(User.class, "language", String.class));
        put("primaryDeviceOs", ReflectionUtils.findField(User.class, "primaryDeviceOs", String.class));
        put("apiVersion", ReflectionUtils.findField(User.class, "apiVersion", Integer.class));
        put("viberVersion", ReflectionUtils.findField(User.class, "viberVersion", String.class));
        put("mcc", ReflectionUtils.findField(User.class, "mcc", Integer.class));
        put("mnc", ReflectionUtils.findField(User.class, "mnc", Integer.class));
        put("deviceType", ReflectionUtils.findField(User.class, "deviceType", String.class));
    }};
    public static final Constructor<User> constructor;

    static {
        try {
            constructor = ReflectionUtils.accessibleConstructor(User.class);
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }

        fields.forEach((key, value) -> value.setAccessible(true));
    }

    public static User create() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return create("01234567890A=", "John McClane", "http://avatar.example.com", "UK", "en", "android 7.1", 1, "6.5.0", 1, 1, "iPhone9,4");
    }

    public static User create(String id, String name, String avatar, String country, String language, String primaryDeviceOs, Integer apiVersion, String viberVersion, Integer mcc, Integer mnc, String deviceType) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        User user = constructor.newInstance();
        ReflectionUtils.setField(fields.get("id"), user, id);
        ReflectionUtils.setField(fields.get("name"), user, name);
        ReflectionUtils.setField(fields.get("avatar"), user, avatar);
        ReflectionUtils.setField(fields.get("country"), user, country);
        ReflectionUtils.setField(fields.get("language"), user, language);
        ReflectionUtils.setField(fields.get("primaryDeviceOs"), user, primaryDeviceOs);
        ReflectionUtils.setField(fields.get("apiVersion"), user, apiVersion);
        ReflectionUtils.setField(fields.get("viberVersion"), user, viberVersion);
        ReflectionUtils.setField(fields.get("mcc"), user, mcc);
        ReflectionUtils.setField(fields.get("mnc"), user, mnc);
        ReflectionUtils.setField(fields.get("deviceType"), user, deviceType);
        return user;
    }
}
