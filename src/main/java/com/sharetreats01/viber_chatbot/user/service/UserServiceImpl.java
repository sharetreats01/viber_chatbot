package com.sharetreats01.viber_chatbot.user.service;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.UserDto;
import com.sharetreats01.viber_chatbot.user.entity.UserEntity;
import com.sharetreats01.viber_chatbot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    @Transactional
    public UserEntity subscribe(UserDto userDto) {
        UserEntity entity = new UserEntity(userDto.getId(), userDto.getName(), userDto.getAvatar(), userDto.getCountry(), userDto.getLanguage(), userDto.getApiVersion(), true);
        repository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public UserEntity unsubscribe(UserDto userDto) {
        UserEntity entity = repository.findById(userDto.getId()).orElseThrow();
        entity.unsubscribe();
        return entity;
    }
}
