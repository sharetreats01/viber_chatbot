package com.sharetreats01.viber_chatbot.hyelin.controller;


import com.sharetreats01.viber_chatbot.order.dto.request.OrderByBotRequest;
import com.sharetreats01.viber_chatbot.order.dto.response.OrderSuccessResponse;
import com.sharetreats01.viber_chatbot.order.service.OrderService;
import com.sharetreats01.viber_chatbot.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hyelin")
@Slf4j
public class HyelinController {

    private final OrderService orderService;
    private final ProductService productService;
    @GetMapping("/payment-list")
    public ResponseEntity<AvailablePaymentsResponse> getPaymentCase() {
        AvailablePaymentsResponse response = productService.getPaymentList("1");
        log.info(response.getPayments().toString());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/order")
    public ResponseEntity<OrderSuccessResponse> postOrderByBot(@RequestBody OrderByBotRequest requestBody) {
        OrderSuccessResponse response = orderService.createOrderByBot(requestBody);
        return ResponseEntity.ok().body(response);
    }


}
