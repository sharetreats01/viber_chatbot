package com.sharetreats01.viber_chatbot.viber.repository;

import com.sharetreats01.viber_chatbot.viber.enums.KeyboardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ViberKeyboardRepositoryImpl implements ViberKeyboardRepository {
    private final EntityManager em;

    @Override
    public Optional<String> findKeyboardJsonByType(KeyboardType type) {
        return em.createQuery(
                        "select kv.data " +
                                "from ViberKeyboardEntity k " +
                                "left join ViberKeyBoardVersionEntity kv " +
                                "on k.id = kv.keyBoardId where k.keyBoardType =: type order by kv.version desc",
                        String.class)
                .setParameter("type", type)
                .getResultList().stream().findFirst();
    }
}
