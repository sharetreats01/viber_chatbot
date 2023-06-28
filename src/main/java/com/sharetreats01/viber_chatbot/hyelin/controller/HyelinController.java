package com.sharetreats01.viber_chatbot.hyelin.controller;


import com.sharetreats01.viber_chatbot.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hyelin")
public class HyelinController {
    private final OrderService orderService;

    @GetMapping("/brand-list")
    public void doSomething() {
        //
    }
}
