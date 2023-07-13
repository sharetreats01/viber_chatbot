package com.sharetreats01.viber_chatbot.support.handler.treat;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;

import java.util.List;

public interface TreatMessageLinker {
    boolean canLink(String identifier);
    TreatConstantsHandler getHandler(MessageRequest request, List<String> treatParts);
}
