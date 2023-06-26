package com.sharetreats01.viber_chatbot.user.repository;

import com.sharetreats01.viber_chatbot.user.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void 유저_저장_테스트() {
        UserEntity user = new UserEntity("01234567890A=", "John McClane", "http://avatar.example.com", "UK", "en", 1, true);
        UserEntity result = userRepository.save(user);
        assertEquals(user, result);
    }
}