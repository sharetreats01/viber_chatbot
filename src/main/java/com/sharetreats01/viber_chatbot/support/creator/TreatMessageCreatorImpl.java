package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.service.TreatKeyboardService;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.service.MessageService;
import com.sharetreats01.viber_chatbot.support.enums.TreatInputValidType;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.util.TreatDataUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class TreatMessageCreatorImpl implements TreatMessageCreator {
    private final MessageService messageService;
    private final TrackingDataUtils trackingDataUtils;
    private final TreatDataUtils treatDataUtils;
    private final ChatbotProperties chatbotProperties;
    private final TreatKeyboardService keyboardService;

    @Override
    public SendMessageRequest successMessage(MessageRequest request, List<String> treatParts) {
        String message = "";
        String keyboard;
        String input = request.getMessage().getText();
        String trackingData = request.getMessage().getTrackingData();
        State curState = trackingDataUtils.getState(trackingData);
        TreatConstant curConstant = treatDataUtils.getTreatConstant(treatParts);

        if (input.contains("TREAT")) {
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
        trackingData = updateTrackingData(curState, trackingData, input);
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
        log.info("{} {}","new TrackingData : "   , sendMessage.getTrackingData());
        return sendMessage;
    }

    private String updateTrackingData(State curState, String trackingData, String input) {
        switch (curState) {
            case PRODUCTS:
                String pureInput = input.trim().split(" ")[1];
                trackingData = trackingDataUtils.updateThisState(trackingData, State.DETAIL);
                trackingData = trackingDataUtils.updateState(trackingData,pureInput);
                break;
            case DETAIL:
                trackingData = trackingDataUtils.updateThisState(trackingData,State.TREAT);
                break;
            default:
                trackingData = treatDataUtils.updateTreatData(trackingData,input);
                break;
        }
        return trackingData;
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