package com.sharetreats01.viber_chatbot.botMessage.strategy;

import com.sharetreats01.viber_chatbot.botMessage.dto.TemplateDto;
import com.sharetreats01.viber_chatbot.botMessage.dto.MessageTemplateValueDto;

public interface MessageTemplateStrategy<T extends MessageTemplateValueDto> {
    String create(TemplateDto templateDto, T valueDto);
}
