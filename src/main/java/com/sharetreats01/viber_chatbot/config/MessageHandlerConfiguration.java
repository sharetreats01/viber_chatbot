package com.sharetreats01.viber_chatbot.config;

import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.support.handler.message.MessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
