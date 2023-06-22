package com.sharetreats01.viber_chatbot.user.repository;

import com.sharetreats01.viber_chatbot.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
