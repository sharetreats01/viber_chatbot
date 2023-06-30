package com.sharetreats01.viber_chatbot.interaction.support.strategy;

import com.sharetreats01.viber_chatbot.interaction.dto.message.template.TemplateDto;
import com.sharetreats01.viber_chatbot.interaction.dto.message.template.WelcomeMessageTemplateValueDto;
import com.sharetreats01.viber_chatbot.interaction.support.factory.MessageTemplateStrategyFactory;
import com.sharetreats01.viber_chatbot.interaction.util.MessageTemplateUtils;
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
        // 각자 맞게 value 리스트를 생성
        List<String> values = List.of(valueDto.getUserName(), valueDto.getBotName());
        Map<String, String> result = MessageTemplateUtils.createTemplateValues(placeHolders, values);
        return MessageTemplateUtils.processTemplate(templateDto.getTemplate(), result);
    }
}
