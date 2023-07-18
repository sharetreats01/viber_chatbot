package com.sharetreats01.viber_chatbot.support.handler.treat;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.Sender;
import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendPictureMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.service.TreatKeyboardService;
import com.sharetreats01.viber_chatbot.order.dto.request.OrderByBotRequest;
import com.sharetreats01.viber_chatbot.order.dto.response.OrderSuccessResponse;
import com.sharetreats01.viber_chatbot.order.service.OrderService;
import com.sharetreats01.viber_chatbot.support.creator.TreatMessageCreator;
import com.sharetreats01.viber_chatbot.support.enums.TreatInputValidType;
import com.sharetreats01.viber_chatbot.util.TreatDataUtils;
import com.sharetreats01.viber_chatbot.util.UserInputValidator;
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
