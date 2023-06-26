package com.sharetreats01.viber_chatbot.user.service;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.User;

public interface UserService {
    void subscribe(User user);
    void unsubscribe(String id);
}
