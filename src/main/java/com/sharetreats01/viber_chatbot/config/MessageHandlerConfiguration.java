package com.sharetreats01.viber_chatbot.config;

import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.support.handler.message.MessageHandler;
import com.sharetreats01.viber_chatbot.support.handler.treat.TreatConstantsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class MessageHandlerConfiguration {
    @Bean
    public Map<State, MessageHandler> messageHandlers(List<MessageHandler> handlers) {
        return handlers.stream().collect(Collectors.toMap(MessageHandler::getMessageHandleType, Function.identity()));
    }

    @Bean
    public Map<State, State> handlerPath() {
        Map<State, State> handlerPath = new HashMap<>();
        handlerPath.put(State.BRANDS, State.PRODUCTS);
        handlerPath.put(State.PRODUCTS, State.DETAIL);
        handlerPath.put(State.DETAIL, State.TREAT);
        handlerPath.put(State.TREAT, State.TREAT);
        return handlerPath;
    }

    @Bean
    public Map<TreatConstant, TreatConstantsHandler> treatConstantsHandlers(List<TreatConstantsHandler> constantsHandlers) {
        return constantsHandlers.stream().collect(Collectors.toMap(TreatConstantsHandler::getConstantsType, Function.identity()));
    }

    @Bean
    public Map<TreatConstant, List<TreatConstant>> treatPath() {
        Map<TreatConstant, List<TreatConstant>> treatPath = new HashMap<>();
        treatPath.put(TreatConstant.ME, Arrays.asList(TreatConstant.YOUR_INFO, TreatConstant.PROMO_CODE, TreatConstant.PAYMENT, TreatConstant.END));
        treatPath.put(TreatConstant.FRIEND, Arrays.asList(TreatConstant.RECIPIENT, TreatConstant.YOUR_INFO, TreatConstant.MESSAGE, TreatConstant.PROMO_CODE, TreatConstant.PAYMENT, TreatConstant.END));
        return treatPath;
    }
}
