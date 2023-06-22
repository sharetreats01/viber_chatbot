package com.sharetreats01.viber_chatbot.user.service;

import com.sharetreats01.viber_chatbot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
