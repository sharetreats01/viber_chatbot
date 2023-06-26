package com.sharetreats01.viber_chatbot.user.service;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.User;
import com.sharetreats01.viber_chatbot.user.entity.UserEntity;
import com.sharetreats01.viber_chatbot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    @Transactional
    public UserEntity subscribe(User user) {
        UserEntity entity = new UserEntity(user.getId(), user.getName(), user.getAvatar(), user.getCountry(), user.getLanguage(), user.getApiVersion(), true);
        repository.save(entity);
        log.info("User Save: {}", entity);
        return entity;
    }

    @Override
    @Transactional
    public UserEntity unsubscribe(User user) {
        UserEntity entity = repository.findById(user.getId()).orElseThrow();
        entity.unsubscribe();
        return entity;
    }
}
