package com.sharetreats01.viber_chatbot.viber.repository;

import com.sharetreats01.viber_chatbot.viber.entity.ViberWebhookSettingEntity;
import com.sharetreats01.viber_chatbot.viber.exception.ViberException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ViberRepositoryImpl implements ViberRepository {
    private final EntityManager em;

    @Override
    public ViberWebhookSettingEntity findRecentWebhookSetting() {
        return em.createQuery(
                        "select ws " +
                                "from ViberWebhookSettingEntity ws " +
                                "order by ws.createdAt desc ",
                        ViberWebhookSettingEntity.class)
                .getResultList().stream().findFirst().orElseThrow(() -> new ViberException("웹훅 설정이 없습니다. 어플리케이션이 종료됩니다."));
    }

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
                        "select pr.data from ViberProductsRichMediaEntity pr where pr.brand =: brand", String.class
                ).setParameter("brand", brand)
                .getResultList().stream().findFirst();
    }
}
