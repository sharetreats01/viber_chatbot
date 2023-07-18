package com.sharetreats01.viber_chatbot.infra.viber.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharetreats01.viber_chatbot.enums.ActionType;
import com.sharetreats01.viber_chatbot.enums.TextHAlign;
import com.sharetreats01.viber_chatbot.enums.TextSize;
import com.sharetreats01.viber_chatbot.enums.TextVAlign;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.property.Keyboard;
import com.sharetreats01.viber_chatbot.util.KeyboardConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

@Slf4j
@Service
public class ProductDetailMessageService {
    public String getProductDetailKeyboard(ProductDetailResponse productDetail) {
        Keyboard.Button[] buttons = new Keyboard.Button[2];

        buttons[0] = Keyboard.Button.builder()
                .columns(KeyboardConstants.PRODUCT_DETAIL_BUTTONS_COLUMNS)
                .rows(KeyboardConstants.PRODUCT_DETAIL_FIRST_BUTTONS_ROWS)
                .bgColor(KeyboardConstants.BUTTON_BG_COLOR)
                .actionType(ActionType.OPEN_URL)
                .actionBody(productDetail.getParticipationUrl())
                .text(KeyboardConstants.SEE_PARTICIPATING_STORE)
                .textSize(TextSize.LARGE)
                .textVAlign(TextVAlign.MIDDLE)
                .textHAlign(TextHAlign.CENTER)
                .build();

        buttons[1] = Keyboard.Button.builder()
                .columns(KeyboardConstants.PRODUCT_DETAIL_BUTTONS_COLUMNS)
                .rows(KeyboardConstants.PRODUCT_DETAIL_SECOND_BUTTONS_ROWS)
                .bgColor(KeyboardConstants.BUTTON_BG_COLOR)
                .actionType(ActionType.REPLY)
                .actionBody(KeyboardConstants.SEND_TREAT_ACTIONBODY + productDetail.getProductId())
                .text(KeyboardConstants.SEND_TREAT)
                .textSize(TextSize.LARGE)
                .textVAlign(TextVAlign.MIDDLE)
                .textHAlign(TextHAlign.CENTER)
                .build();

        Keyboard keyboard = Keyboard.builder()
                .buttons(buttons)
                .build();

        return convertToJson(keyboard);
    }

    public String getProductDetailText(ProductDetailResponse productDetail) {
        String newline = "\n";

        StringJoiner text = new StringJoiner(newline);
        text.add(productDetail.getBrandName())
                .add(productDetail.getProductName())
                .add(productDetail.getOriginPrice() + " -> "
                        + productDetail.getDiscountPrice() + newline)
                .add(productDetail.getDescription());

        return text.toString();
    }

    private String convertToJson(Object keyboard) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(keyboard);
        } catch (JsonProcessingException e) {
            log.error("Error occurred while converting to JSON: {}", e.getMessage());
            throw new RuntimeException("Error while processing Object JSON: " + e.getMessage(), e);
        }
    }
}
