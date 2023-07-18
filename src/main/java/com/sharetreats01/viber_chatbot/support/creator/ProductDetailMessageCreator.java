package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.dto.response.ProductDetailResponse;
import com.sharetreats01.viber_chatbot.infra.sharetreats.product.service.ProductService;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.service.ProductDetailMessageService;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductDetailMessageCreator extends AbstractMessageCreator {
    private final ProductService productService;
    private final ChatbotProperties chatbotProperties;
    private final ProductDetailMessageService productDetailMessageService;

    public ProductDetailMessageCreator(TrackingDataUtils trackingDataUtils, ProductService productService,
                                       ChatbotProperties chatbotProperties, ProductDetailMessageService productDetailMessageService) {
        super(trackingDataUtils);
        this.productService = productService;
        this.chatbotProperties = chatbotProperties;
        this.productDetailMessageService = productDetailMessageService;
    }

    @Override
    protected String createTrackingData(String trackingData, String input) {
        return trackingDataUtils.updateData(trackingData, input);
    }

    public SendMessageRequest createMessageRequest(MessageRequest request) {
        String receiver = getReceiverId(request);
        String input = request.getMessage().getText();
        String trackingData = createTrackingData(request.getMessage().getTrackingData(), input);

        Long productId = Long.parseLong(request.getMessage().getText());
        ProductDetailResponse productDetail = productService.getProductDetail(productId);

        String text = productDetailMessageService.getProductDetailText(productDetail);

        return new SendTextMessageRequest(receiver, chatbotProperties.getBotName(),
                chatbotProperties.getBotAvatar(), 7, text, trackingData);
    }
}
