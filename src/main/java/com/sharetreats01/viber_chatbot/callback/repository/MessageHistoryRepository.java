package com.sharetreats01.viber_chatbot.callback.repository;

import com.sharetreats01.viber_chatbot.callback.entity.MessageHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageHistoryRepository extends JpaRepository<MessageHistoryEntity, UUID> {
}
