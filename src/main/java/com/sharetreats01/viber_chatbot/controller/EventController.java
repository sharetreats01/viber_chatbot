package com.sharetreats01.viber_chatbot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EventController {

    @PostMapping("/event/botstart")
    public void conversationStart() {
        System.out.println("converstation_started");
    }
}
