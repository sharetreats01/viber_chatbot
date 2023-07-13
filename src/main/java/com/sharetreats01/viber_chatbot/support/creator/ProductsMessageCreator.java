package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendRichMediaMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.service.RichMediaService;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductsMessageCreator extends AbstractMessageCreator {
    private final RichMediaService richMediaService;

    public ProductsMessageCreator(TrackingDataUtils trackingDataUtils, RichMediaService richMediaService) {
        super(trackingDataUtils);
        this.richMediaService = richMediaService;
    }

    public SendMessageRequest createMessageRequest(MessageRequest request) {
        String receiver = getReceiverId(request);
        String input = request.getMessage().getText();
        String trackingData = createTrackingData(request.getMessage().getTrackingData(), input);

        return new SendRichMediaMessageRequest(receiver, request.getSender().getApiVersion(), richMediaService.findProductsByBrand(input), trackingData);
    }

    @Override
    protected String createTrackingData(String trackingData, String input) {
        return trackingDataUtils.updateState(trackingData, input);
    }
}
