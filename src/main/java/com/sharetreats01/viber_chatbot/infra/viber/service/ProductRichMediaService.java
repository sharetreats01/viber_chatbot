package com.sharetreats01.viber_chatbot.infra.viber.service;

import com.sharetreats01.viber_chatbot.enums.*;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.property.Keyboard;
import org.springframework.stereotype.Service;

@Service
public class ProductRichMediaService {
    public Keyboard getProductDetailRichMedia(ProductDetailResponse productDetail) {
        Keyboard.Button[] buttons = new Keyboard.Button[2];

        buttons[0] = Keyboard.Button.builder()
                .columns(6)
                .rows(6)
                .text(productDetail.getDescription())
                .imageScaleType(ScaleType.FIT)
                .actionType(ActionType.NONE)
                .textSize(TextSize.REGULAR)
                .textVAlign(TextVAlign.MIDDLE)
                .textHAlign(TextHAlign.LEFT)
                .build();

        buttons[1] = Keyboard.Button.builder()
                .columns(6)
                .rows(1)
                .bgColor("#87CEEB")
                .actionType(ActionType.OPEN_URL)
                .actionBody("https://www.google.com")
                .text("<font color=#ffffff>Send Treat</font>")
                .textSize(TextSize.REGULAR)
                .textVAlign(TextVAlign.MIDDLE)
                .textHAlign(TextHAlign.CENTER)
                .frame(new Keyboard.Button.Frame(null, null, 10))
                .build();

        return Keyboard.builder()
                .buttonsGroupColumns(6)
                .buttonsGroupRows(7)
                .bgColor("#FFFFFF")
                .buttons(buttons)
                .build();
    }
}
