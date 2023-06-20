package com.sharetreats01.viber_chatbot.callback;

import com.sharetreats01.viber_chatbot.callback.dto.ConversationStarted;
import com.sharetreats01.viber_chatbot.callback.dto.Sender;
import com.sharetreats01.viber_chatbot.callback.dto.WelcomeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserCallbackController {
    @PostMapping("/sharetreats01_chatbot")
    public ResponseEntity<WelcomeMessage> conversationStarted(@RequestBody ConversationStarted callback) {
        return ResponseEntity.ok(WelcomeMessage.builder()
                .sender(new Sender("John McClane", "http://avatart.example.com"))
                .trackingData("tracking_data")
                .type("picture")
                .text("Welcome to our bot!")
                .media("http://www.images.com/img/img.jpg")
                .thumbnail("http://www.images.com/thumb/jpg")
                .build());
    }
}
