package com.sharetreats01.viber_chatbot.callback.handler.message;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.State;
import com.sharetreats01.viber_chatbot.callback.handler.treat.TreatConstantsHandler;
import com.sharetreats01.viber_chatbot.callback.handler.treat.TreatMessageLinker;
import com.sharetreats01.viber_chatbot.botMessage.creator.TreatMessageCreator;
import com.sharetreats01.viber_chatbot.botMessage.util.TreatDataUtils;
import com.sharetreats01.viber_chatbot.client.viber.client.ViberWebClient;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.client.viber.exception.ViberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
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
        List<String> combinedParts = treatDataUtils.combineTreatData(request.getMessage().getTrackingData(), request.getMessage().getText());
        String identifier = treatDataUtils.getTreatLinkerIdentifier(combinedParts);

        SendMessageRequest sendMessageRequest;

        if (identifier.equals("TREAT")) {
            sendMessageRequest = treatMessageCreator.successMessage(request, combinedParts);
        } else if (identifier.startsWith("TREAT")
                && identifier.split(" ").length == 2) {
            sendMessageRequest = treatMessageCreator.successMessage(request,combinedParts);
        }else {
            TreatConstantsHandler handler = treatMessageLinkers.stream()
                    .filter(linker -> linker.canLink(identifier))
                    .findFirst()
                    .orElseThrow(() -> new ViberException("Not Found Treat Handler Linker: " + combinedParts))
                    .getHandler(request, combinedParts);
            sendMessageRequest = handler.handle(request, combinedParts);
        }
        viberWebClient.sendMessage(sendMessageRequest);
    }
}
