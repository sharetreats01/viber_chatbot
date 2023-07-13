package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendRichMediaMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.service.RichMediaService;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailMessageCreator extends AbstractMessageCreator {
    private final RichMediaService richMediaService;

    public ProductDetailMessageCreator(TrackingDataUtils trackingDataUtils, RichMediaService richMediaService) {
        super(trackingDataUtils);
        this.richMediaService = richMediaService;
    }

    @Override
    protected String createTrackingData(String trackingData, String input) {
        return trackingDataUtils.updateData(trackingData, input);
    }

    public SendMessageRequest createMessageRequest(MessageRequest request) {
        String receiver = getReceiverId(request);
        String trackingData = request.getMessage().getTrackingData();
        String input = request.getMessage().getText();
        return new SendRichMediaMessageRequest(receiver, 7, richMediaService.findProductDetailByProductId(trackingDataUtils.extractBrand(trackingData), input), createTrackingData(trackingData, input));
    }
}
