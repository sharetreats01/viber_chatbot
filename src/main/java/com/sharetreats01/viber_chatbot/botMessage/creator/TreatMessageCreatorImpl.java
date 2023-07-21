package com.sharetreats01.viber_chatbot.botMessage.creator;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.util.TreatDataUtils;
import com.sharetreats01.viber_chatbot.botMessage.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.service.keyboard.TreatKeyboardService;
import com.sharetreats01.viber_chatbot.callback.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.botMessage.service.message.MessageService;
import com.sharetreats01.viber_chatbot.botMessage.enums.input.TreatInputValidType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class TreatMessageCreatorImpl implements TreatMessageCreator {
    private final MessageService messageService;
    private final TreatDataUtils treatDataUtils;
    private final ChatbotProperties chatbotProperties;
    private final TreatKeyboardService keyboardService;

    @Override
    public SendMessageRequest successMessage(MessageRequest request, List<String> treatParts) {
        String keyboard;
        String message = "";
        String input = request.getMessage().getText();
        String trackingData = request.getMessage().getTrackingData();
        TreatConstant curConstant = treatDataUtils.getTreatConstant(treatParts);

        if (request.getMessage().getText().contains("TREAT")) {
            message = curConstant.getTextMesage();
            keyboard = keyboardService.targetKeyboard();
        } else {
            curConstant = treatDataUtils.getNextTreatConstant(treatParts, input);
            message = curConstant.getTextMesage();
            switch (curConstant) {
                case PAYMENT:
                    keyboard = keyboardService.paymentListKeyboard(treatParts);
                    break;
                default:
                    keyboard = keyboardService.getKeyboardByConstant(curConstant);
            }
        }

        trackingData = treatDataUtils.updateTreatData(trackingData, input);
        SendTextMessageRequest sendMessage =  new SendTextMessageRequest(
            request.getSender().getId(),
            chatbotProperties.getBotName(),
            chatbotProperties.getBotAvatar(),
            request.getSender().getApiVersion(),
            message,
            trackingData
        );
        if (!keyboard.isBlank()) {
            sendMessage.setKeyboard(keyboard);
        }
        return sendMessage;
    }

    @Override
    public SendMessageRequest failureMessage(MessageRequest request, List<String> treatParts, String errorName) {
        TreatConstant constant = treatDataUtils.getTreatConstant(treatParts);
        String trackingData = request.getMessage().getTrackingData();
        String message = TreatInputValidType.getMessageFromName(errorName);

        SendMessageRequest sendRequest = new SendTextMessageRequest(
                request.getSender().getId(),
                chatbotProperties.getBotName(),
                chatbotProperties.getBotAvatar(),
                request.getSender().getApiVersion(),
                message,
                trackingData
        );

        String keyboard = "";
        switch (constant) {
            case PAYMENT:
                keyboard = keyboardService.paymentListKeyboard(treatParts);
                break;
            default:
                keyboard = keyboardService.getKeyboardByConstant(constant);
                break;
        }
        if (!keyboard.isBlank()) sendRequest.setKeyboard(keyboard);
        return sendRequest;
    }
}