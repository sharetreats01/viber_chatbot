package com.sharetreats01.viber_chatbot.support.handler.message;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.order.enums.OrderFormState;
import com.sharetreats01.viber_chatbot.order.util.OrderTrackingDataUtil;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendTextMessageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageOrderFormHandler extends AbstractMessageHandler implements MessageHandler {
    private final TrackingDataUtils trackingDataUtils;
    public MessageOrderFormHandler(ViberWebClient webClient, ChatbotProperties chatbotProperties, TrackingDataUtils trackingDataUtils) {
        super(webClient, chatbotProperties);
        this.trackingDataUtils = trackingDataUtils;
    }

    @Override
    public State getMessageHandleType() {
        return State.ORDER;
    }
    @Override
    public void handle(MessageRequest request) {
        super.sendResponse(request);
    }

    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest request) {
        String trackingData = request.getMessage().getTrackingData();
        OrderFormState curState = OrderTrackingDataUtil.getOrderState(trackingData);

        if (curState == OrderFormState.FORM_END) {
            trackingData = trackingDataUtils
                .updateNextState(trackingData, trackingDataUtils.getState(trackingData));
        } else{
            curState = OrderFormState.next(curState);
            trackingData = OrderTrackingDataUtil.updateValue(trackingData,request.getMessage().getText());
        }

        return new SendTextMessageRequest(
            request.getSender().getId(),
            request.getSender().getName(),
            request.getSender().getAvatar(),
            request.getSender().getApiVersion(),
            curState.getTextMessage(),
            trackingData
        );

    }
}
