package com.sharetreats01.viber_chatbot.repository;

import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.enums.TreatResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TreatMessageRepositoryImpl implements TreatMessageRepository {
    private final EntityManager entityManager;

    @Override
    public Optional<String> findSuccessFirstByConstantAndVersion(TreatConstant constant) {
        return entityManager.createQuery(
                        "select tm.template " +
                                "from TreatMessageTemplateEntity tm " +
                                "where tm.type =: type and tm.constant =: constant " +
                                "order by tm.version desc",
                        String.class)
                .setParameter("type", TreatResult.SUCCESS)
                .setParameter("constant", constant)
                .getResultList().stream().findFirst();
    }

    @Override
    public Optional<String> findFailureFirstByConstantAndVersion(TreatConstant constant) {
        return entityManager.createQuery(
                        "select tm.template " +
                                "from TreatMessageTemplateEntity tm " +
                                "where tm.type =: type and tm.constant =: constant " +
                                "order by tm.version desc",
                        String.class)
                .setParameter("type", TreatResult.FAILURE)
                .setParameter("constant", constant)
                .getResultList().stream().findFirst();    }
}
