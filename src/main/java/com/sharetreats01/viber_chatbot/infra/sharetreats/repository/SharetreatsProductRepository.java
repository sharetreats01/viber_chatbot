package com.sharetreats01.viber_chatbot.infra.sharetreats.repository;

import com.sharetreats01.viber_chatbot.infra.sharetreats.entity.ShareTreatsProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SharetreatsProductRepository extends JpaRepository<ShareTreatsProductEntity, Long> {
}
