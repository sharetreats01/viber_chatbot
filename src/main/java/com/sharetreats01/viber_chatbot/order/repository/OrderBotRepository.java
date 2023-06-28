package com.sharetreats01.viber_chatbot.order.repository;

import com.sharetreats01.viber_chatbot.order.entity.BotOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderBotRepository extends JpaRepository<BotOrder,Long> {
}
