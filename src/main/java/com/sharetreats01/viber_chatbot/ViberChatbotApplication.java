package com.sharetreats01.viber_chatbot;

import com.sharetreats01.viber_chatbot.viber.service.ViberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@RequiredArgsConstructor
public class ViberChatbotApplication {
    private final ViberService viberService;

    public static void main(String[] args) {
        SpringApplication.run(ViberChatbotApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
    public void setWebhookSetting() throws IOException {
        viberService.setViberWebhook();
    }
}
