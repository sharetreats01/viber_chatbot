package com.sharetreats01.viber_chatbot.viber.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ViberKeyboardRepositoryImpl implements ViberKeyboardRepository {
    private final EntityManager em;

    @Override
    public Optional<String> findKeyboardJsonByType(String type) {
        return em.createQuery(
                        "select kv.data " +
                                "from ViberKeyboardEntity k " +
                                "inner join ViberKeyBoardVersionEntity kv " +
                                "on k.id = kv.keyBoardId where k.keyBoardType =: type order by kv.version desc",
                        String.class)
                .setParameter("type", type)
                .getResultList().stream().findFirst();
    }

    @Override
    public Optional<String> findProductsRichMediaByBrand(String brand) {
        return em.createQuery(
                        "select pr from ViberProductsRichMediaEntity pr where pr.brand =: brand", String.class
                ).setParameter("brand", brand)
                .getResultList().stream().findFirst();
    }
}
