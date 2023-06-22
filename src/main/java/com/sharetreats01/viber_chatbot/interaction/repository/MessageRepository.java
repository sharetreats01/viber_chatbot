package com.sharetreats01.viber_chatbot.interaction.repository;

import com.sharetreats01.viber_chatbot.interaction.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
}
