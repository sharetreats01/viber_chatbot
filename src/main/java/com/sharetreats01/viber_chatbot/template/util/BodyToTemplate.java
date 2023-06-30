package com.sharetreats01.viber_chatbot.template.util;

import com.sharetreats01.viber_chatbot.product.dto.request.GetBrandRequest;
import com.sharetreats01.viber_chatbot.product.dto.response.BrandListResponse;
import com.sharetreats01.viber_chatbot.product.service.ProductService;
import com.sharetreats01.viber_chatbot.template.body.KeyBoardBody;
import com.sharetreats01.viber_chatbot.template.body.component.Button;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
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
}
