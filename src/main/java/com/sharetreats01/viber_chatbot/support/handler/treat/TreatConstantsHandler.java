package com.sharetreats01.viber_chatbot.support.handler.treat;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;

import java.util.List;

public interface TreatConstantsHandler {
    TreatConstant getConstantsType();

    SendMessageRequest handle(MessageRequest request, List<String> combinedTreatParts);
}
