package com.sharetreats01.viber_chatbot.controller;

import com.sharetreats01.viber_chatbot.dto.callback.request.CallbackRequest;
import com.sharetreats01.viber_chatbot.dispatcher.CallbackDispatcher;
import com.sharetreats01.viber_chatbot.dto.callback.response.CallbackResponse;
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
    private final CallbackDispatcher<CallbackRequest, CallbackResponse> callbackDispatcher;
    @PostMapping("/sharetreats01_chatbot")
    public <T extends CallbackRequest> ResponseEntity<?> callback(@RequestBody T request) {
        return ResponseEntity.ok(callbackDispatcher.dispatch(request));
    }
}
