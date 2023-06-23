package com.sharetreats01.viber_chatbot.interaction.support.strategy;

import com.sharetreats01.viber_chatbot.interaction.dto.TemplateDto;
import com.sharetreats01.viber_chatbot.interaction.dto.message.template.MessageTemplateValueDto;

public interface MessageTemplateStrategy<T extends MessageTemplateValueDto> {
    String create(TemplateDto templateDto, T valueDto);
}
