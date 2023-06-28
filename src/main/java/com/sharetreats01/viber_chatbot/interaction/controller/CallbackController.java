package com.sharetreats01.viber_chatbot.interaction.controller;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.CallbackRequest;
import com.sharetreats01.viber_chatbot.interaction.dispatcher.CallbackDispatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CallbackController {
    private final CallbackDispatcher callbackDispatcher;
    @PostMapping("/sharetreats01_chatbot")
    public ResponseEntity<?> callback(@RequestBody CallbackRequest request) {
        return ResponseEntity.ok(callbackDispatcher.dispatch(request));
    }
}
