package com.sharetreats01.viber_chatbot.callback.handler.treat;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.botMessage.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.botMessage.util.TreatDataUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TreatMessageLinkerFriend implements TreatMessageLinker {
    private final TreatDataUtils treatDataUtils;
    private final Map<TreatConstant, TreatConstantsHandler> handlers;
    @Override
    public boolean canLink(String identifier) {
        return TreatConstant.FRIEND.name().equals(identifier);
    }

    @Override
    public TreatConstantsHandler getHandler(MessageRequest request, List<String> treatParts) {
        TreatConstant constants = treatDataUtils.getTreatConstant(treatParts);
        return handlers.get(constants);
    }
}
