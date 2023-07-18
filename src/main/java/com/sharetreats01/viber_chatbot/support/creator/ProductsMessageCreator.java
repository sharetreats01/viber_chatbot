package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.service.ProductService;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendProductRichMediaMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.property.Keyboard;
import com.sharetreats01.viber_chatbot.infra.viber.service.KeyBoardService;
import com.sharetreats01.viber_chatbot.infra.viber.service.ProductRichMediaService;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductsMessageCreator extends AbstractMessageCreator {
    private final ProductRichMediaService productRichMediaService;
    private final KeyBoardService keyBoardService;
    private final ProductService productService;

    public ProductsMessageCreator(TrackingDataUtils trackingDataUtils, ProductRichMediaService productRichMediaService,
                                  KeyBoardService keyBoardService, ProductService productService) {
        super(trackingDataUtils);
        this.productRichMediaService = productRichMediaService;
        this.keyBoardService = keyBoardService;
        this.productService = productService;
    }

    @Override
    protected String createTrackingData(String trackingData, String input) {
        return trackingDataUtils.updateState(trackingData, input);
    }

    public SendMessageRequest createMessageRequest(MessageRequest request) {
        String receiver = getReceiverId(request);
        String input = request.getMessage().getText();
        String trackingData = createTrackingData(request.getMessage().getTrackingData(), input);

        Long brandId = Long.valueOf(request.getMessage().getText());
        ProductListResponse products = productService.getProducts(brandId);
        Keyboard richMedia = productRichMediaService.getProductsRichMedia(products);

        SendProductRichMediaMessageRequest messageRequest =
                new SendProductRichMediaMessageRequest(receiver, 7, richMedia, trackingData);

        messageRequest.setKeyboard(keyBoardService.findBrands());

        return messageRequest;
    }
}
