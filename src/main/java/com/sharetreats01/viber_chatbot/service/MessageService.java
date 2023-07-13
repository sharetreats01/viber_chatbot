package com.sharetreats01.viber_chatbot.service;

import com.sharetreats01.viber_chatbot.dto.message.template.TemplateDto;
import com.sharetreats01.viber_chatbot.dto.message.template.MessageTemplateValueDto;
import com.sharetreats01.viber_chatbot.entity.MessageTemplateEntity;
import com.sharetreats01.viber_chatbot.entity.MessageTemplatePlaceHolderEntity;
import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.exception.MessageTemplateException;
import com.sharetreats01.viber_chatbot.repository.MessageTemplateRepository;
import com.sharetreats01.viber_chatbot.support.factory.MessageTemplateStrategyFactory;
import com.sharetreats01.viber_chatbot.support.strategy.MessageTemplateStrategy;
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

    public String findTreatSuccessMessage(TreatConstant constant) {
        return "";
    }

    public String findTreatFailureMessage(TreatConstant constant) {
        return "";
    }

    public String createMessage(MessageTemplateValueDto valueDto) {
        MessageTemplateStrategy<MessageTemplateValueDto> strategy = templateStrategyFactory.getInstance(valueDto);
        MessageTemplateEntity entity =
                messageTemplateRepository
                        .findTopByTypeAndLanguageOrderByVersionDesc(valueDto.getType(), valueDto.getLanguage())
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
