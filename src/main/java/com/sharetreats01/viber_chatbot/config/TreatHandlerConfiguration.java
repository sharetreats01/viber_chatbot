package com.sharetreats01.viber_chatbot.config;

import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.support.handler.treat.TreatConstantsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class TreatHandlerConfiguration {
    @Bean
    public Map<TreatConstant, TreatConstantsHandler> treatConstantsHandlers(List<TreatConstantsHandler> constantsHandlers) {
        return constantsHandlers.stream().collect(Collectors.toMap(TreatConstantsHandler::getConstantsType, Function.identity()));
    }
}
