package com.sharetreats01.viber_chatbot.interaction.repository;

import com.sharetreats01.viber_chatbot.interaction.entity.MessageTemplateEntity;
import com.sharetreats01.viber_chatbot.interaction.enums.MessageType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageTemplateRepository extends JpaRepository<MessageTemplateEntity, Integer> {
    Optional<MessageTemplateEntity> findTopByTypeAndLanguageOrderByVersion(MessageType type, String language);
}
