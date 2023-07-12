package com.sharetreats01.viber_chatbot.infra.viber.service;

import com.sharetreats01.viber_chatbot.enums.*;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.parameter.Product;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.property.Keyboard;
import java.util.List;
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
                .actionBody("order-" + productDetail.getProductId())
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

    public Keyboard getProductsRichMedia(ProductListResponse productsList) {
        int index = 0;
        int size = productsList.getProducts().size();
        Keyboard.Button[] buttons = new Keyboard.Button[size * 4];
        List<Product> products = productsList.getProducts();

        for (int i = 0; i < size; i++) {
            buttons[index++] = Keyboard.Button.builder()
                    .columns(6)
                    .rows(3)
                    .imageScaleType(ScaleType.FIT)
                    .actionType(ActionType.NONE)
                    .image(products.get(i).getImgUrl())
                    .build();

            buttons[index++] = Keyboard.Button.builder()
                    .columns(6)
                    .rows(2)
                    .actionType(ActionType.NONE)
                    .text(products.get(i).getName())
                    .textSize(TextSize.SMALL)
                    .textVAlign(TextVAlign.MIDDLE)
                    .textHAlign(TextHAlign.LEFT)
                    .build();

            buttons[index++] = Keyboard.Button.builder()
                    .columns(6)
                    .rows(1)
                    .bgColor("#87CEEB")
                    .actionType(ActionType.OPEN_URL)
                    .actionBody("order-" + products.get(i).getId())
                    .text("<font color=#ffffff>Send Treat</font>")
                    .textSize(TextSize.LARGE)
                    .textVAlign(TextVAlign.MIDDLE)
                    .textHAlign(TextHAlign.CENTER)
                    .build();

            buttons[index++] = Keyboard.Button.builder()
                    .columns(6)
                    .rows(1)
                    .actionType(ActionType.REPLY)
                    .actionBody(products.get(i).getId().toString())
                    .text("<font color=#ffffff>View more</font>")
                    .textSize(TextSize.SMALL)
                    .textVAlign(TextVAlign.MIDDLE)
                    .textHAlign(TextHAlign.CENTER)
                    .build();
        }

        return Keyboard.builder()
                .buttonsGroupColumns(6)
                .buttonsGroupRows(7)
                .bgColor("#FFFFFF")
                .buttons(buttons)
                .build();
    }
}
