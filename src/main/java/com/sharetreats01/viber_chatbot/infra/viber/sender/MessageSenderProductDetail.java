package com.sharetreats01.viber_chatbot.infra.viber.sender;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.service.ProductService;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendProductRichMediaMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendRichMediaMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.property.Keyboard;
import com.sharetreats01.viber_chatbot.infra.viber.service.ProductRichMediaService;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.infra.viber.service.RichMediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSenderProductDetail extends AbstractMessageSender implements MessageSender {
    private final RichMediaService richMediaService;
    private final ProductService productService;
    private final ProductRichMediaService productRichMediaService;

    public MessageSenderProductDetail(ViberWebClient webClient, ChatbotProperties chatbotProperties,
                                      RichMediaService richMediaService, ProductService productService,
                                      ProductRichMediaService productRichMediaService) {
        super(webClient, chatbotProperties);
        this.richMediaService = richMediaService;
        this.productService = productService;
        this.productRichMediaService = productRichMediaService;
    }

    @Override
    public State getSenderKey() {
        return State.PRODUCTS;
    }

    @Override
    public void send(MessageRequest request) {
        super.sendResponse(request);
    }

    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest messageRequest) {
        Long productId = Long.parseLong(messageRequest.getMessage().getText());
        ProductDetailResponse productDetail = productService.getProductDetail(productId);
        Keyboard richMedia = productRichMediaService.getProductDetailRichMedia(productDetail);

        String trackingData = TrackingDataUtils.updateState(messageRequest.getMessage().getTrackingData(),
                State.PRODUCT_DETAIL, messageRequest.getMessage().getText());
        return new SendProductRichMediaMessageRequest(messageRequest.getSender().getId(), 7, richMedia, trackingData);
    }
}
