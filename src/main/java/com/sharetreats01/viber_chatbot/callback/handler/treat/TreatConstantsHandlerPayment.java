package com.sharetreats01.viber_chatbot.callback.handler.treat;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.Sender;
import com.sharetreats01.viber_chatbot.botMessage.service.keyboard.TreatKeyboardService;
import com.sharetreats01.viber_chatbot.botMessage.creator.TreatMessageCreator;
import com.sharetreats01.viber_chatbot.botMessage.util.TreatDataUtils;
import com.sharetreats01.viber_chatbot.botMessage.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendPictureMessageRequest;
import com.sharetreats01.viber_chatbot.client.order.dto.request.OrderByBotRequest;
import com.sharetreats01.viber_chatbot.client.order.dto.response.OrderSuccessResponse;
import com.sharetreats01.viber_chatbot.client.order.service.OrderService;
import com.sharetreats01.viber_chatbot.botMessage.enums.input.TreatInputValidType;
import com.sharetreats01.viber_chatbot.botMessage.util.UserInputValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TreatConstantsHandlerPayment implements TreatConstantsHandler {
    private final OrderService orderService;
    private final TreatMessageCreator treatMessageCreator;
    private final TreatKeyboardService keyboardService;
    private final TreatDataUtils treatDataUtils;
    private final UserInputValidator userInputValidator;

    @Override
    public TreatConstant getConstantsType() {
        return TreatConstant.PAYMENT;
    }

    @Override
    public String checkInput(String input) {
        return TreatInputValidType.VALID_INPUT.name();
    }

    @Override
    public SendMessageRequest handle(MessageRequest request, List<String> combinedTreatParts) {
        OrderByBotRequest orderRequest = treatDataUtils.mapToOrderRequest(request, combinedTreatParts);
        OrderSuccessResponse orderResponse = orderService.createOrderByBot(orderRequest);
        return makeOrderMessage(orderResponse, request.getSender());
    }

    private SendMessageRequest makeOrderMessage(OrderSuccessResponse response, Sender sender) {
        SendPictureMessageRequest messageRequest = new SendPictureMessageRequest(
                sender.getId(),
                sender.getName(),
                sender.getAvatar(),
                sender.getApiVersion(),
                "",
                response.getProductUrl(),
                response.getProductUrl()
        );
        messageRequest.setText(response.toPictureBodyString());
        messageRequest.setKeyboard(keyboardService.orderSuccessMessageKeyboard(response));
        return messageRequest;
    }

}
