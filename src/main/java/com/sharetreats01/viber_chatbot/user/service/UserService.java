package com.sharetreats01.viber_chatbot.user.service;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.UserDto;
import com.sharetreats01.viber_chatbot.user.entity.UserEntity;

public interface UserService {
    UserEntity subscribe(UserDto userDto);
    UserEntity unsubscribe(UserDto userDto);
}
