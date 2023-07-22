package com.sharetreats01.viber_chatbot.botMessage.creator;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.MessageRequest;
import com.sharetreats01.viber_chatbot.client.viber.dto.request.SendMessageRequest;

import java.util.List;

public interface TreatMessageCreator {
    SendMessageRequest successMessage(MessageRequest request, List<String> treatParts);
    SendMessageRequest failureMessage(MessageRequest request, List<String> treatParts, String ErrorCase);
}
