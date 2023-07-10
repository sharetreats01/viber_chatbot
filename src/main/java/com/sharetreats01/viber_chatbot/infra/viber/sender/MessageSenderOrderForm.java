package com.sharetreats01.viber_chatbot.infra.viber.sender;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.service.OrderKeyboardService;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.order.enums.OrderFormState;
import com.sharetreats01.viber_chatbot.order.util.OrderTrackingDataUtil;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendTextMessageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageSenderOrderForm extends AbstractMessageSender implements MessageSender{
    private final OrderKeyboardService orderKeyboardService;

    public MessageSenderOrderForm( ViberWebClient webClient, ChatbotProperties chatbotProperties, OrderKeyboardService orderKeyboardService) {
        super(webClient, chatbotProperties);
        this.orderKeyboardService = orderKeyboardService;
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
        String keyboard = "";

        if (curState == OrderFormState.FORM_END) {
            trackingData = TrackingDataUtils.updateNextState(trackingData, State.PAYMENT);
        } else{
            curState = OrderFormState.next(curState);
            trackingData = OrderTrackingDataUtil.updateValue(trackingData,request.getMessage().getText());
        }

        SendTextMessageRequest messageRequest = new SendTextMessageRequest(
            request.getSender().getId(),
            request.getSender().getName(),
            request.getSender().getAvatar(),
            request.getSender().getApiVersion(),
            curState.getTextMessage(),
            trackingData
        );

        switch (curState) {
            case INPUT_CODE:
                keyboard = orderKeyboardService.promoCodeKeyboard();
                messageRequest.setKeyboard(keyboard);
                break;
            case FORM_END:
                keyboard = orderKeyboardService.paymentListKeyboard(trackingData);
                messageRequest.setKeyboard(keyboard);
                break;
            default:
                break;
        }
        log.info(curState.toString(), keyboard);
        return messageRequest;
    }
}
