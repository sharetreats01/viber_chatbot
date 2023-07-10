package com.sharetreats01.viber_chatbot.infra.viber.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharetreats01.viber_chatbot.enums.ActionType;
import com.sharetreats01.viber_chatbot.enums.TextHAlign;
import com.sharetreats01.viber_chatbot.enums.TextSize;
import com.sharetreats01.viber_chatbot.enums.TextVAlign;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.AvailablePaymentsResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.service.ProductService;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.property.Keyboard;
import com.sharetreats01.viber_chatbot.order.dto.response.OrderSuccessResponse;
import com.sharetreats01.viber_chatbot.order.util.OrderTrackingDataUtil;
import com.sharetreats01.viber_chatbot.template.body.KeyBoardBody;
import com.sharetreats01.viber_chatbot.template.body.component.Button;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class OrderKeyboardService {
    public final ProductService productService;

    public OrderKeyboardService(ProductService productService) {
        this.productService = productService;
    }

    public String promoCodeKeyboard() {
        Keyboard.Button[] buttons = new Keyboard.Button[1];
        buttons[0] = Keyboard.Button.builder()
            .columns(6).rows(1).bgColor("#7765F2")
            .actionType(ActionType.REPLY)
            .actionBody("N")
            .text("<font color=\"#F9FBFD\">No Thanks</font>")
            .textSize(TextSize.LARGE)
            .textVAlign(TextVAlign.MIDDLE)
            .textHAlign(TextHAlign.CENTER)
            .build();

        return keyboard2JsonString(Keyboard.builder()
            .buttons(buttons)
            .build());
    }

    public String paymentListKeyboard(String trackingData) {
        String productId = OrderTrackingDataUtil.getProductId(trackingData);
        AvailablePaymentsResponse response = productService.getPaymentList(productId);

        List<Button> buttons = response.getPayments().stream()
            .map(payment -> new Button.paymentBuilder()
                .payementId(payment.getId())
                .name(payment.getName())
                .originPrice(payment.getOriginPrice())
                .discountedPrice(payment.getDiscountPrice())
                .discounted(payment.isDiscounted())
                .build()
            )
            .collect(Collectors.toList());
        return keyboard2JsonString(
            KeyBoardBody.builder()
            .buttons(buttons)
            .build());
    }


    public String orderSuccessMessageKeyboard(OrderSuccessResponse response) {
        Keyboard.Button[] buttons = new Keyboard.Button[3];
        buttons[0] = Keyboard.Button.builder()
            .columns(6).rows(1).bgColor("#7765F2")
            .actionType(ActionType.OPEN_URL)
            .actionBody(response.getParticipatingUrl())
            .text("<font color=\"#F9FBFD\">see participating stores</font>")
            .textSize(TextSize.LARGE)
            .textVAlign(TextVAlign.MIDDLE)
            .textHAlign(TextHAlign.CENTER)
            .build();
        buttons[1] = Keyboard.Button.builder()
            .columns(6).rows(1).bgColor("#7765F2")
            .actionType(ActionType.OPEN_URL)
            .actionBody(response.getTermsOfUse())
            .text("<font color=\"#F9FBFD\">terms of use</font>")
            .textSize(TextSize.LARGE)
            .textVAlign(TextVAlign.MIDDLE)
            .textHAlign(TextHAlign.CENTER)
            .build();
        buttons[2] = Keyboard.Button.builder()
            .columns(6).rows(1).bgColor("#7765F2")
            .actionType(ActionType.REPLY)
            .actionBody(response.getTermsOfUse())
            .text("<font color=\"#F9FBFD\">close chat</font>")
            .textSize(TextSize.REGULAR)
            .textVAlign(TextVAlign.MIDDLE)
            .textHAlign(TextHAlign.CENTER)
            .build();

        return keyboard2JsonString(
            Keyboard.builder()
            .buttons(buttons)
            .build()
        );
    }

    /**
     * @deprecated
     * **임시** : keyboard를 JSON String으로 변환시키는 메소드
     * @return (JSON String) keyboard
     */
    private static String keyboard2JsonString (Object keyboard){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(keyboard);
        }catch (JsonProcessingException je) {
            return "";
        }
    }
}
