package com.sharetreats01.viber_chatbot.botMessage.strategy;

import com.sharetreats01.viber_chatbot.botMessage.dto.TemplateDto;
import com.sharetreats01.viber_chatbot.botMessage.dto.WelcomeMessageTemplateValueDto;
import com.sharetreats01.viber_chatbot.botMessage.factory.MessageTemplateStrategyFactory;
import com.sharetreats01.viber_chatbot.botMessage.util.MessageTemplateUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WelcomeMessageTemplateStrategy implements MessageTemplateStrategy<WelcomeMessageTemplateValueDto> {
    public WelcomeMessageTemplateStrategy(MessageTemplateStrategyFactory factory) {
        factory.registerStrategy(WelcomeMessageTemplateValueDto.class, this);
    }

    @Override
    public String create(TemplateDto templateDto, WelcomeMessageTemplateValueDto valueDto) {
        List<String> placeHolders = templateDto.getPlaceHolders();
        List<String> values = List.of(valueDto.getUserName(), valueDto.getBotName());
        Map<String, String> result = MessageTemplateUtils.createTemplateValues(placeHolders, values);
        return MessageTemplateUtils.processTemplate(templateDto.getTemplate(), result);
    }
}
