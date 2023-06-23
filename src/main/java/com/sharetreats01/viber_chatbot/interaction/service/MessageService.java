package com.sharetreats01.viber_chatbot.interaction.service;

import com.sharetreats01.viber_chatbot.util.MessageTemplateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MessageService {
    public String testCreateMessage(String[] placeHolders, String[] values) {
        Map<String, String> valueMap = MessageTemplateUtils.createTemplateValues(placeHolders, values);
        return MessageTemplateUtils.processTemplate("Hello ${name1}! Welcome to our bot.\nMy name is ${name2}.", valueMap);
    }

}
