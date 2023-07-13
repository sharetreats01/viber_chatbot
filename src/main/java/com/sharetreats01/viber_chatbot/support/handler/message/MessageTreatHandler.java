package com.sharetreats01.viber_chatbot.support.handler.message;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.infra.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.infra.viber.exception.ViberException;
import com.sharetreats01.viber_chatbot.support.creator.TreatMessageCreator;
import com.sharetreats01.viber_chatbot.support.handler.treat.TreatConstantsHandler;
import com.sharetreats01.viber_chatbot.support.handler.treat.TreatMessageLinker;
import com.sharetreats01.viber_chatbot.util.TreatDataUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageTreatHandler implements MessageHandler {
    private final ViberWebClient viberWebClient;
    private final TreatDataUtils treatDataUtils;
    private final TreatMessageCreator treatMessageCreator;
    private final List<TreatMessageLinker> treatMessageLinkers;

    @Override
    public State getMessageHandleType() {
        return State.TREAT;
    }

    @Override
    public void handle(MessageRequest request) {
        List<String> treatParts = treatDataUtils.combineTreatData(request.getMessage().getTrackingData(), request.getMessage().getText());
        String identifier = treatDataUtils.getTreatLinkerIdentifier(treatParts);

        SendMessageRequest sendMessageRequest;

        if (identifier.equals("TREAT")) {
            sendMessageRequest = treatMessageCreator.successMessage(request, treatParts);
        } else {
            TreatConstantsHandler handler = treatMessageLinkers.stream()
                    .filter(linker -> linker.canLink(identifier))
                    .findFirst()
                    .orElseThrow(() -> new ViberException("Not Found Treat Handler Linker: " + treatParts))
                    .getHandler(request, treatParts);

            sendMessageRequest = handler.handle(request, treatParts);
        }
        viberWebClient.sendMessage(sendMessageRequest);
    }
}