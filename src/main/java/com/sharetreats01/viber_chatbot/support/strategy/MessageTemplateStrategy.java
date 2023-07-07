package com.sharetreats01.viber_chatbot.support.strategy;

import com.sharetreats01.viber_chatbot.dto.message.template.TemplateDto;
import com.sharetreats01.viber_chatbot.dto.message.template.MessageTemplateValueDto;

public interface MessageTemplateStrategy<T extends MessageTemplateValueDto> {
    String create(TemplateDto templateDto, T valueDto);
}
