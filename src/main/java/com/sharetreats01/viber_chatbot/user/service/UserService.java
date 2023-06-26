package com.sharetreats01.viber_chatbot.user.service;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.UserDto;
import com.sharetreats01.viber_chatbot.user.entity.UserEntity;

public interface UserService {
    void subscribe(UserDto userDto);
    void unsubscribe(UserDto userDto);
}
