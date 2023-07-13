package com.sharetreats01.viber_chatbot.infra.viber.sender;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendPictureMessageRequest;
import com.sharetreats01.viber_chatbot.order.dto.request.OrderByBotRequest;
import com.sharetreats01.viber_chatbot.order.dto.response.OrderSuccessResponse;
import com.sharetreats01.viber_chatbot.order.service.OrderService;
import com.sharetreats01.viber_chatbot.order.util.OrderTrackingDataUtil;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSenderPayment extends AbstractMessageSender implements MessageSender{
    private final OrderService orderService;

    public MessageSenderPayment(ViberWebClient webClient, ChatbotProperties chatbotProperties,
        OrderService orderService) {
        super(webClient, chatbotProperties);
        this.orderService = orderService;
    }

    @Override
    public State getSenderKey() {
        return State.PAYMENT;
    }

    @Override
    public void send(MessageRequest request) {
        super.sendResponse(request);
    }

    @Override
    protected void createSendMessageRequest(
        MessageRequest request) {
        String paymentMethodId = request.getMessage().getText();

        OrderByBotRequest orderRequest =
            OrderTrackingDataUtil.trackingData2OrderRequest(request, paymentMethodId);

        OrderSuccessResponse orderResponse = orderService.createOrderByBot(orderRequest);

        SendPictureMessageRequest orderMessage = new SendPictureMessageRequest(
            request.getSender().getId(),
            request.getSender().getName(),
            request.getSender().getAvatar(),
            request.getSender().getApiVersion(),
            "",
            orderResponse.getProductUrl(),
            orderResponse.getProductUrl()
        );
        orderMessage.setText(orderResponse.toPictureBodyString());
    }
}
