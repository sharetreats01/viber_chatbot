package com.sharetreats01.viber_chatbot.infra.viber.sender;

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
public class MessageSenderOrderForm extends AbstractMessageSender implements MessageSender{
    public MessageSenderOrderForm(ViberWebClient webClient, ChatbotProperties chatbotProperties) {
        super(webClient, chatbotProperties);
    }

    @Override
    public State getSenderKey() {
        return State.ORDER;
    }
    @Override
    public void send(MessageRequest request) {
        super.sendResponse(request);
    }

    @Override
    protected SendMessageRequest createSendMessageRequest(MessageRequest request) {
        String trackingData = request.getMessage().getTrackingData();
        OrderFormState curState = OrderTrackingDataUtil.getOrderState(trackingData);

        if (curState == OrderFormState.FORM_END) {
            trackingData = TrackingDataUtils
                .updateNextState(trackingData, TrackingDataUtils.getState(trackingData));

            // payment keyboard 메시지 만들어서 전송하기
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
