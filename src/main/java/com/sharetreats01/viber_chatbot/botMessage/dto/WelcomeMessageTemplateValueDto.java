package com.sharetreats01.viber_chatbot.botMessage.dto;

import com.sharetreats01.viber_chatbot.client.viber.enums.MessageType;
import lombok.Getter;

@Getter
public class WelcomeMessageTemplateValueDto extends MessageTemplateValueDto {
    private final String userName;
    private final String botName;

    public WelcomeMessageTemplateValueDto(MessageType type, String language, String userName, String botName) {
        super(type, language);
        this.userName = userName;
        this.botName = botName;
    }
}
