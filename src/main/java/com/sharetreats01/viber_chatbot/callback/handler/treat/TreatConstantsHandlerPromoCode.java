package com.sharetreats01.viber_chatbot.callback.handler.treat;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.creator.TreatMessageCreator;
import com.sharetreats01.viber_chatbot.botMessage.enums.input.TreatInputValidType;
import com.sharetreats01.viber_chatbot.botMessage.util.UserInputValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TreatConstantsHandlerPromoCode implements TreatConstantsHandler {
    private final TreatMessageCreator treatMessageCreator;
    private final UserInputValidator userInputValidator;


    @Override
    public TreatConstant getConstantsType() {
        return TreatConstant.PROMO_CODE;
    }

    @Override
    public String checkInput(String input) {
        return userInputValidator.checkPromoCodeValid(input);
    }

    @Override
    public SendMessageRequest handle(MessageRequest request, List<String> treatParts) {
        SendMessageRequest messageRequest;
        String validMessage = checkInput(request.getMessage().getText());
        if (!validMessage.equals(TreatInputValidType.VALID_INPUT.name())) {
            messageRequest = treatMessageCreator.failureMessage(request,treatParts,validMessage);
        }else {
            messageRequest = treatMessageCreator.successMessage(request, treatParts);
        }
        return messageRequest;
    }
}
