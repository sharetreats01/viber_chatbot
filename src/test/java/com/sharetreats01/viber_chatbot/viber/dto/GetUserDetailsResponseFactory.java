package com.sharetreats01.viber_chatbot.viber.dto;

import com.sharetreats01.viber_chatbot.user.dto.User;
import com.sharetreats01.viber_chatbot.user.dto.UserFactory;
import com.sharetreats01.viber_chatbot.viber.dto.response.GetUserDetailsResponse;
import com.sharetreats01.viber_chatbot.viber.enums.Status;

import java.lang.reflect.InvocationTargetException;

public class GetUserDetailsResponseFactory {

    public static GetUserDetailsResponse create() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return create(Status.OK, "ok", 4912661846655238145L, UserFactory.create());
    }

    public static GetUserDetailsResponse create(Status status, String statusMessage, Long messageToken, User user) {
        return new GetUserDetailsResponse(status, statusMessage, messageToken, user);
    }
}
