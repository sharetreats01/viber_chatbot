package com.sharetreats01.viber_chatbot.interaction.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("classpath:properties/viber/viber.properties")
public class ViberProperties {
    @Value("${bot-name}")
    private String botName;

    @Value("${bot-avatar}")
    private String botAvatar;

    @Value("${bot-thumbnail}")
    private String botThumbnail;
}
