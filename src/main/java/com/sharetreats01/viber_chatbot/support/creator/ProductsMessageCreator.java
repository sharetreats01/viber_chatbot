package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductListResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.service.ProductService;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendProductRichMediaMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.property.Keyboard;
import com.sharetreats01.viber_chatbot.infra.viber.service.ProductRichMediaService;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductsMessageCreator extends AbstractMessageCreator {
    //    private final RichMediaService richMediaService;
    private final ProductService productService;
    private final ProductRichMediaService productRichMediaService;

    public ProductsMessageCreator(TrackingDataUtils trackingDataUtils, ProductRichMediaService productRichMediaService,
                                  ProductService productService) {
        super(trackingDataUtils);
        this.productRichMediaService = productRichMediaService;
        this.productService = productService;
    }

    public SendMessageRequest createMessageRequest(MessageRequest request) {
        String receiver = getReceiverId(request);
        String input = request.getMessage().getText();
        String trackingData = createTrackingData(request.getMessage().getTrackingData(), input);

        String brandName = request.getMessage().getText();
        ProductListResponse products = productService.getProducts(brandName);
        Keyboard richMedia = productRichMediaService.getProductsRichMedia(products);

        return new SendProductRichMediaMessageRequest(receiver, 7, richMedia, trackingData);
    }

    @Override
    protected String createTrackingData(String trackingData, String input) {
        return trackingDataUtils.updateState(trackingData, input);
    }
}
