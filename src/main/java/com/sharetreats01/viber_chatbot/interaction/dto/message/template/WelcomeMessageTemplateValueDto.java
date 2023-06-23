package com.sharetreats01.viber_chatbot.interaction.dto.message.template;

import com.sharetreats01.viber_chatbot.interaction.enums.MessageType;
import lombok.Getter;

@Getter
public class WelcomeMessageTemplateValueDto extends MessageTemplateValueDto {
    private final String userName;

    public WelcomeMessageTemplateValueDto(MessageType type, String language, String userName) {
        super(type, language);
        this.userName = userName;
    }
}
