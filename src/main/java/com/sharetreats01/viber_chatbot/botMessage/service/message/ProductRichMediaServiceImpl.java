package com.sharetreats01.viber_chatbot.botMessage.service.message;

import com.sharetreats01.viber_chatbot.botMessage.enums.*;
import com.sharetreats01.viber_chatbot.botMessage.property.KeyboardConstants;
import com.sharetreats01.viber_chatbot.client.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.client.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.client.product.dto.response.parameter.Product;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.property.Keyboard;
import org.springframework.stereotype.Service;

@Service
public class ProductRichMediaServiceImpl implements ProductRichMediaService {
    @Override
    public Keyboard getProductDetailRichMedia(ProductDetailResponse productDetail) {
        Keyboard.Button[] buttons = new Keyboard.Button[2];

        buttons[0] = Keyboard.Button.builder()
                .columns(KeyboardConstants.PRODUCT_DETAIL_BUTTONS_COLUMNS)
                .rows(KeyboardConstants.PRODUCT_DETAIL_FIRST_BUTTONS_ROWS)
                .text(productDetail.getDescription())
                .imageScaleType(ScaleType.FIT)
                .actionType(ActionType.NONE)
                .textSize(TextSize.REGULAR)
                .textVAlign(TextVAlign.MIDDLE)
                .textHAlign(TextHAlign.LEFT)
                .build();

        buttons[1] = Keyboard.Button.builder()
                .columns(KeyboardConstants.PRODUCT_DETAIL_BUTTONS_COLUMNS)
                .rows(KeyboardConstants.PRODUCT_DETAIL_SECOND_BUTTONS_ROWS)
                .bgColor(KeyboardConstants.BUTTON_BG_COLOR)
                .actionType(ActionType.REPLY)
                .actionBody(productDetail.getProductId().toString())
                .text(KeyboardConstants.SEND_TREAT)
                .textSize(TextSize.REGULAR)
                .textVAlign(TextVAlign.MIDDLE)
                .textHAlign(TextHAlign.CENTER)
                .frame(new Keyboard.Button.Frame(null, null, KeyboardConstants.FRAME_CORNER_RADIUS))
                .build();

        return Keyboard.builder()
                .buttonsGroupColumns(KeyboardConstants.BUTTONS_GROUP_COLUMNS_MAX)
                .buttonsGroupRows(KeyboardConstants.BUTTONS_GROUP_ROWS_MAX)
                .bgColor(KeyboardConstants.BG_COLOR)
                .buttons(buttons)
                .build();
    }

    @Override
    public Keyboard getProductsRichMedia(ProductListResponse productsList) {
        int index = 0;
        int size = productsList.getProducts().size();
        Keyboard.Button[] buttons = new Keyboard.Button[size * 4];

        for (int i = 0; i < size; i++) {
            buttons[index++] = Keyboard.Button.builder()
                    .columns(KeyboardConstants.PRODUCT_BUTTONS_COLUMNS)
                    .rows(KeyboardConstants.PRODUCT_FIRST_BUTTONS_ROWS)
                    .imageScaleType(ScaleType.FIT)
                    .actionType(ActionType.NONE)
                    .image(productsList.getProducts().get(i).getImgUrl())
                    .build();

            buttons[index++] = Keyboard.Button.builder()
                    .columns(KeyboardConstants.PRODUCT_BUTTONS_COLUMNS)
                    .rows(KeyboardConstants.PRODUCT_SECOND_BUTTONS_ROWS)
                    .actionType(ActionType.NONE)
                    .text(getText(productsList.getProducts().get(i)))
                    .textSize(TextSize.REGULAR)
                    .textVAlign(TextVAlign.MIDDLE)
                    .textHAlign(TextHAlign.LEFT)
                    .build();

            buttons[index++] = Keyboard.Button.builder()
                    .columns(KeyboardConstants.PRODUCT_BUTTONS_COLUMNS)
                    .rows(KeyboardConstants.PRODUCT_THIRD_BUTTONS_ROWS)
                    .bgColor(KeyboardConstants.BUTTON_BG_COLOR)
                    .actionType(ActionType.REPLY)
                    .actionBody(productsList.getProducts().get(i).getId().toString())
                    .text(KeyboardConstants.SEND_TREAT)
                    .textSize(TextSize.LARGE)
                    .textVAlign(TextVAlign.MIDDLE)
                    .textHAlign(TextHAlign.CENTER)
                    .frame(new Keyboard.Button.Frame(null, null, KeyboardConstants.FRAME_CORNER_RADIUS))
                    .build();

            buttons[index++] = Keyboard.Button.builder()
                    .columns(KeyboardConstants.PRODUCT_BUTTONS_COLUMNS)
                    .rows(KeyboardConstants.PRODUCT_FOURTH_BUTTONS_ROWS)
                    .actionType(ActionType.REPLY)
                    .actionBody(productsList.getProducts().get(i).getId().toString())
                    .text(KeyboardConstants.VIEW_MORE)
                    .textSize(TextSize.SMALL)
                    .textVAlign(TextVAlign.MIDDLE)
                    .textHAlign(TextHAlign.CENTER)
                    .build();
        }

        return Keyboard.builder()
                .buttonsGroupColumns(KeyboardConstants.BUTTONS_GROUP_COLUMNS_MAX)
                .buttonsGroupRows(KeyboardConstants.BUTTONS_GROUP_ROWS_MAX)
                .bgColor(KeyboardConstants.BG_COLOR)
                .buttons(buttons)
                .build();
    }

    private String getText(Product product) {
        return product.getName()
                + "<br><br>"
                + product.getBrandName()
                + "<b><br>"
                + product.getPriceFormatted()
                + "</b>";
    }
}
