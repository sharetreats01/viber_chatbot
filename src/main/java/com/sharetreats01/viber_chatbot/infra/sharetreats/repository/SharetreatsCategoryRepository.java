package com.sharetreats01.viber_chatbot.infra.sharetreats.repository;

import com.sharetreats01.viber_chatbot.infra.sharetreats.entity.ShareTreatsCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SharetreatsCategoryRepository extends JpaRepository<ShareTreatsCategoryEntity, Integer> {
}
