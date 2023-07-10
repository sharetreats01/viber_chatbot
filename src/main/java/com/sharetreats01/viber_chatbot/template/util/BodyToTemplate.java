package com.sharetreats01.viber_chatbot.template.util;

import com.sharetreats01.viber_chatbot.order.dto.response.OrderSuccessResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.request.GetBrandRequest;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.BrandListResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.service.ProductService;
import com.sharetreats01.viber_chatbot.template.body.KeyBoardBody;
import com.sharetreats01.viber_chatbot.template.body.PhotoTypeMessage;
import com.sharetreats01.viber_chatbot.template.body.RichMediaTypeMessage;
import com.sharetreats01.viber_chatbot.template.body.component.Button;
import com.sharetreats01.viber_chatbot.template.body.component.RichButton;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class BodyToTemplate {
    private final ProductService productService;
    public KeyBoardBody makeBrandKeyboard () {
        BrandListResponse brandList = productService.getBrandList(
                new GetBrandRequest()
        );

        List<Button> buttons = brandList.getBrands().stream()
                .map(brand -> new Button.builder()
                        .text(brand.getName())
                        .actionBody(brand.getId().toString())
                        .image(brand.getImgUrl())
                        .build()
                )
                .collect(Collectors.toList());

        return KeyBoardBody.builder()
                .buttons(buttons)
                .build();
    }

    public PhotoTypeMessage makePictureMessage(OrderSuccessResponse orderSuccessDto) {
        return new PhotoTypeMessage(orderSuccessDto);
    }

    public static RichMediaTypeMessage makeOrderSuccessLinkButtons (OrderSuccessResponse orderSuccessDto) {
        List<RichButton> buttons = new ArrayList<>();
        buttons.add(new RichButton.builder()
                .actionBody(orderSuccessDto.getParticipatingUrl())
                .text("see participating stores")
                .build()
        );
        buttons.add(new RichButton.builder()
            .actionBody(orderSuccessDto.getParticipatingUrl())
            .text("terms of use")
            .build()
        );

        RichMediaTypeMessage message = new RichMediaTypeMessage();
        message.setButtons(buttons);
        return message;

    }
}
