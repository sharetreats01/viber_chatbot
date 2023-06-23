package com.sharetreats01.viber_chatbot.interaction.service;

import com.sharetreats01.viber_chatbot.interaction.dto.TemplateDto;
import com.sharetreats01.viber_chatbot.interaction.dto.message.template.MessageTemplateValueDto;
import com.sharetreats01.viber_chatbot.interaction.entity.MessageTemplateEntity;
import com.sharetreats01.viber_chatbot.interaction.entity.MessageTemplatePlaceHolderEntity;
import com.sharetreats01.viber_chatbot.interaction.exception.MessageTemplateException;
import com.sharetreats01.viber_chatbot.interaction.repository.MessageTemplateRepository;
import com.sharetreats01.viber_chatbot.interaction.support.factory.MessageTemplateStrategyFactory;
import com.sharetreats01.viber_chatbot.interaction.support.strategy.MessageTemplateStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageService {
    private final MessageTemplateStrategyFactory templateStrategyFactory;
    private final MessageTemplateRepository messageTemplateRepository;

    public String createMessage(MessageTemplateValueDto valueDto) {
        MessageTemplateStrategy<MessageTemplateValueDto> strategy = templateStrategyFactory.getInstance(valueDto);
        MessageTemplateEntity entity =
                messageTemplateRepository
                        .findTopByTypeAndLanguageOrderByVersion(valueDto.getType(), valueDto.getLanguage())
                        .orElseThrow(() -> new MessageTemplateException("메시지 템플릿을 찾을 수 없습니다."));
        TemplateDto templateDto =
                new TemplateDto(entity.getTemplate(), entity.getTemplateVariableEntities()
                        .stream()
                        .map(MessageTemplatePlaceHolderEntity::getName)
                        .collect(Collectors.toList())
                );
        return strategy.create(templateDto, valueDto);
    }

}
