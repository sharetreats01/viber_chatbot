package com.sharetreats01.viber_chatbot.callback.repository;


import com.sharetreats01.viber_chatbot.botMessage.enums.TreatConstant;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreatMessageRepository {
    Optional<String> findSuccessFirstByConstantAndVersion(TreatConstant constant);
    Optional<String> findFailureFirstByConstantAndVersion(TreatConstant constant);

}
