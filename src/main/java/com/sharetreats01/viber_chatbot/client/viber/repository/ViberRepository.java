package com.sharetreats01.viber_chatbot.client.viber.repository;


import com.sharetreats01.viber_chatbot.client.viber.entity.ViberWebhookSettingEntity;

import java.util.Optional;


public interface ViberRepository {
    ViberWebhookSettingEntity findRecentWebhookSetting();
    Optional<String> findKeyboardJsonByType(String type);
    Optional<String> findProductsRichMediaByBrand(String type);
    Optional<String> findProductDetailRichMediaByBrandAndProductName(String brand, String productName);
}
