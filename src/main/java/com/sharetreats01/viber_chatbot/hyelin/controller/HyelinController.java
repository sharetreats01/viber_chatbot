package com.sharetreats01.viber_chatbot.hyelin.controller;


import com.sharetreats01.viber_chatbot.order.dto.request.OrderByBotRequest;
import com.sharetreats01.viber_chatbot.order.dto.request.OrderRequest;
import com.sharetreats01.viber_chatbot.order.dto.response.OrderSuccessResponse;
import com.sharetreats01.viber_chatbot.order.service.OrderService;
import com.sharetreats01.viber_chatbot.product.dto.request.GetBrandRequest;
import com.sharetreats01.viber_chatbot.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.product.dto.response.BrandListResponse;
import com.sharetreats01.viber_chatbot.product.service.ProductService;
import com.sharetreats01.viber_chatbot.template.body.KeyBoardBody;
import com.sharetreats01.viber_chatbot.template.body.MessageBody;
import com.sharetreats01.viber_chatbot.template.body.PhotoTypeMessage;
import com.sharetreats01.viber_chatbot.template.util.BodyToTemplate;
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
    private final BodyToTemplate bodyToTemplate;
    @GetMapping("/payment-list")
    public ResponseEntity<AvailablePaymentsResponse> getPaymentCase() {
        AvailablePaymentsResponse response = productService.getPaymentList("1");
        log.info(response.getPayments().toString());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/order")
    public ResponseEntity<?> postOrderByBot(@RequestBody OrderByBotRequest requestBody) {
        // response API -> DTO화 시키기
        OrderSuccessResponse response = orderService.createOrderByBot(requestBody);
        PhotoTypeMessage pt = bodyToTemplate.makePictureMessage(response);
        log.info(pt.getThumbnail(),pt.getText(),pt.getMedia());
        return ResponseEntity.ok().body((MessageBody)pt);
    }

    @GetMapping("/brand-list")
    public ResponseEntity<BrandListResponse> getBrandList() {
        BrandListResponse response = productService.getBrandList(new GetBrandRequest());
        return ResponseEntity.ok().body(response);

    }

    @GetMapping("/brands/keyboard")
    public ResponseEntity<KeyBoardBody> getBrandKeyboard() {
        KeyBoardBody keyboard = bodyToTemplate.makeBrandKeyboard();
        return ResponseEntity.ok().body(keyboard);
    }

}
