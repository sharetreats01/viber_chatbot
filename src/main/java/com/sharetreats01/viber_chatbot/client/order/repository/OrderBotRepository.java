package com.sharetreats01.viber_chatbot.client.order.repository;

import com.sharetreats01.viber_chatbot.client.order.entity.BotOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBotRepository extends JpaRepository<BotOrder,Long> {
}
