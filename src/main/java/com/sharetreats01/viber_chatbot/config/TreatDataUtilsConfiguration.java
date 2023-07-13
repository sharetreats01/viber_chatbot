package com.sharetreats01.viber_chatbot.config;

import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class TreatDataUtilsConfiguration {
    @Bean
    public Map<TreatConstant, List<TreatConstant>> treatPath() {
        Map<TreatConstant, List<TreatConstant>> treatPath = new HashMap<>();
        treatPath.put(TreatConstant.ME, Arrays.asList(TreatConstant.YOUR_INFO, TreatConstant.PROMO_CODE, TreatConstant.PAYMENT));
        treatPath.put(TreatConstant.FRIEND, Arrays.asList(TreatConstant.RECIPIENT, TreatConstant.YOUR_INFO, TreatConstant.MESSAGE, TreatConstant.PROMO_CODE, TreatConstant.PAYMENT));
        return treatPath;
    }
}
