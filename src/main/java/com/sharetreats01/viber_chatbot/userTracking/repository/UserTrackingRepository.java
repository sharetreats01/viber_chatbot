package com.sharetreats01.viber_chatbot.userTracking.repository;

import com.sharetreats01.viber_chatbot.userTracking.entity.UserSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserTrackingRepository extends JpaRepository<UserSessionEntity, UUID> {
}
