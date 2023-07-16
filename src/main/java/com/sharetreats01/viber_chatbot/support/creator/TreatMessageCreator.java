package com.sharetreats01.viber_chatbot.support.creator;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.Sender;
import com.sharetreats01.viber_chatbot.infra.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.order.dto.response.OrderSuccessResponse;

import java.util.List;

public interface TreatMessageCreator {
    SendMessageRequest successMessage(MessageRequest request, List<String> treatParts);
    SendMessageRequest failureMessage(MessageRequest request, List<String> treatParts, String ErrorCase);
}
