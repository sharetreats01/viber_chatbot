package com.sharetreats01.viber_chatbot.support.handler.treat;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.support.creator.TreatMessageCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TreatConstantsHandlerPromoCode implements TreatConstantsHandler {
    private final TreatMessageCreator treatMessageCreator;


    @Override
    public TreatConstant getConstantsType() {
        return TreatConstant.PROMO_CODE;
    }

    @Override
    public SendMessageRequest handle(MessageRequest request, List<String> treatParts) {
        return treatMessageCreator.successMessage(request, treatParts);
    }
}
