package com.sharetreats01.viber_chatbot.infra.sharetreats.repository;

import com.sharetreats01.viber_chatbot.infra.sharetreats.entity.ShareTreatsBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SharetreatsBrandRepository extends JpaRepository<ShareTreatsBrandEntity, Integer> {
}
