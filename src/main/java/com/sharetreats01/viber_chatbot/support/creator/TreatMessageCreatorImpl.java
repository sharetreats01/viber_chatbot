package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendTextMessageRequest;
import com.sharetreats01.viber_chatbot.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.service.MessageService;
import com.sharetreats01.viber_chatbot.util.TreatDataUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TreatMessageCreatorImpl implements TreatMessageCreator {
    private final MessageService messageService;
    private final TreatDataUtils treatDataUtils;
    private final ChatbotProperties chatbotProperties;

    @Override
    public SendMessageRequest successMessage(MessageRequest request, List<String> treatParts) {
        TreatConstant constant = treatDataUtils.getTreatConstant(treatParts);
        String trackingData = treatDataUtils.combinePartsToTrackingData(treatParts);
        return new SendTextMessageRequest(request.getSender().getId(), chatbotProperties.getBotName(), chatbotProperties.getBotAvatar(), request.getSender().getApiVersion(), messageService.findTreatSuccessMessage(constant), trackingData);
    }

    @Override
    public SendMessageRequest failureMessage(MessageRequest request, List<String> treatParts) {
        TreatConstant constant = treatDataUtils.getTreatConstant(treatParts);
        String trackingData = treatDataUtils.combinePartsToTrackingData(treatDataUtils.deleteLastInput(treatParts));
        return new SendTextMessageRequest(request.getSender().getId(), chatbotProperties.getBotName(), chatbotProperties.getBotAvatar(), request.getSender().getApiVersion(), messageService.findTreatFailureMessage(constant), trackingData);
    }
}
