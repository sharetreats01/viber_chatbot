package com.sharetreats01.viber_chatbot.viber.repository;


import com.sharetreats01.viber_chatbot.viber.entity.ViberWebhookSettingEntity;

import java.util.Optional;


public interface ViberRepository {
    ViberWebhookSettingEntity findRecentWebhookSetting();
    Optional<String> findKeyboardJsonByType(String type);
    Optional<String> findProductsRichMediaByBrand(String type);
}
