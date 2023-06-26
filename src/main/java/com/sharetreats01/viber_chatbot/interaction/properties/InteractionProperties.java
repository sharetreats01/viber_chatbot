package com.sharetreats01.viber_chatbot.interaction.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("classpath:properties/viber/chatbot.properties")
public class InteractionProperties {
    @Value("${bot-name}")
    private String bot_name;

    @Value("${bot-avatar}")
    private String bot_avatar;

    @Value("${bot-thumbnail}")
    private String bot_thumbnail;
}
