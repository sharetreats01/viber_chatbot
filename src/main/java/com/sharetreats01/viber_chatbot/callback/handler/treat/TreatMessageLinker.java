package com.sharetreats01.viber_chatbot.callback.handler.treat;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;

import java.util.List;

public interface TreatMessageLinker {
    boolean canLink(String identifier);
    TreatConstantsHandler getHandler(MessageRequest request, List<String> treatParts);
}
