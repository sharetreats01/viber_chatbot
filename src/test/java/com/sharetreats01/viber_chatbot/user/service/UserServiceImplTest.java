package com.sharetreats01.viber_chatbot.user.service;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.UserDtoFactory;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.User;
import com.sharetreats01.viber_chatbot.user.entity.UserEntity;
import com.sharetreats01.viber_chatbot.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.InvocationTargetException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private UserEntity unsubscribedUserEntity;
    private UserEntity subscribedUserEntity;
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.unsubscribedUserEntity = new UserEntity("01234567890A=", "John McClane", "http://avatar.example.com", "UK", "en", 1, false);
        this.subscribedUserEntity = new UserEntity("01234567890A=", "John McClane", "http://avatar.example.com", "UK", "en", 1, true);
    }

    @Test
    public void 유저_구독_테스트() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        User user = UserDtoFactory.createUserDto("01234567890A=", "John McClane", "http://avatar.example.com", "UK", "en", 1);
        when(userRepository.save(any(UserEntity.class))).thenReturn(subscribedUserEntity);

        userService.subscribe(user);

        verify(userRepository, times(1)).save(subscribedUserEntity);
    }
}