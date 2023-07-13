package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.service.ProductService;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendProductRichMediaMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.property.Keyboard;
import com.sharetreats01.viber_chatbot.infra.viber.service.ProductRichMediaService;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailMessageCreator extends AbstractMessageCreator {
    private final ProductService productService;
    private final ProductRichMediaService productRichMediaService;

    public ProductDetailMessageCreator(TrackingDataUtils trackingDataUtils, ProductService productService, ProductRichMediaService productRichMediaService) {
        super(trackingDataUtils);
        this.productService = productService;
        this.productRichMediaService = productRichMediaService;
    }

    @Override
    protected String updateTrackingData(String trackingData) {
        return trackingDataUtils.updateState(trackingData, State.DETAIL);
    }

    @Override
    protected SendMessageRequest createMessageRequest(String receiver, String trackingData) {
        Long productId = Long.parseLong(trackingDataUtils.getData(trackingData));
        ProductDetailResponse productDetail = productService.getProductDetail(productId);
        Keyboard richMedia = productRichMediaService.getProductDetailRichMedia(productDetail);

        return new SendProductRichMediaMessageRequest(receiver, 7, richMedia, trackingData);
    }
}
