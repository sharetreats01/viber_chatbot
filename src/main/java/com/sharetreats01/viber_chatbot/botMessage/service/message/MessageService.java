package com.sharetreats01.viber_chatbot.botMessage.service.message;

import com.sharetreats01.viber_chatbot.botMessage.dto.MessageTemplateValueDto;
import com.sharetreats01.viber_chatbot.botMessage.dto.TemplateDto;
import com.sharetreats01.viber_chatbot.callback.entity.MessageTemplateEntity;
import com.sharetreats01.viber_chatbot.callback.entity.MessageTemplatePlaceHolderEntity;
import com.sharetreats01.viber_chatbot.botMessage.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.callback.exception.MessageTemplateException;
import com.sharetreats01.viber_chatbot.botMessage.factory.MessageTemplateStrategyFactory;
import com.sharetreats01.viber_chatbot.botMessage.strategy.MessageTemplateStrategy;
import com.sharetreats01.viber_chatbot.callback.repository.MessageTemplateRepository;
import com.sharetreats01.viber_chatbot.callback.repository.TreatMessageRepository;
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
    private final TreatMessageRepository treatMessageRepository;


    public String findTreatSuccessMessage(TreatConstant constant) {
        return treatMessageRepository.findSuccessFirstByConstantAndVersion(constant).orElseThrow();
    }

    public String findTreatFailureMessage(TreatConstant constant) {
        return treatMessageRepository.findFailureFirstByConstantAndVersion(constant).orElseThrow();
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

    public String findBrandsMessage() {
        return "Select Brand";
    }
}
