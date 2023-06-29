package com.sharetreats01.viber_chatbot.template.body.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("classpath:properties/viber/chatbot.properties")
public class Sender {
    @Value("${bot-name}")
    private String name;

    @Value("${bot-avatar}")
    private String avatar;
}
