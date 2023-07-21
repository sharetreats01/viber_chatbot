package com.sharetreats01.viber_chatbot.callback.handler.treat;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;

import java.util.List;

public interface TreatConstantsHandler {
    TreatConstant getConstantsType();

    String checkInput(String input);

    SendMessageRequest handle(MessageRequest request, List<String> combinedTreatParts);
}
