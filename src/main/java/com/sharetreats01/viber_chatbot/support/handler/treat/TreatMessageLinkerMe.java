package com.sharetreats01.viber_chatbot.support.handler.treat;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.enums.TreatConstant;
import com.sharetreats01.viber_chatbot.util.TreatDataUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TreatMessageLinkerMe implements TreatMessageLinker {
    private final Map<TreatConstant, TreatConstantsHandler> treatHandler;
    private final TreatDataUtils treatDataUtils;
    @Override
    public boolean canLink(String identifier) {
        return TreatConstant.ME.name().equals(identifier);
    }

    @Override
    public TreatConstantsHandler getHandler(MessageRequest request, List<String> treatParts) {
        TreatConstant constants = treatDataUtils.getTreatConstant(treatParts);
        return treatHandler.get(constants);
    }
}
