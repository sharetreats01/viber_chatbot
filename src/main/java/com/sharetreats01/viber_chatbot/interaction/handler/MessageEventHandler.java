package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Status;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.MessageResponse;
import com.sharetreats01.viber_chatbot.viber.sender.MessageSender;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MessageEventHandler implements CallbackEventHandler<MessageRequest, MessageResponse> {
    private final Map<Status, MessageSender> senders;

    public MessageEventHandler(List<MessageSender> senderList) {
        this.senders = senderList.stream().collect(Collectors.toMap(MessageSender::getSenderKey, Function.identity()));
    }

    @Override
    public Class<MessageRequest> getCallbackType() {
        return MessageRequest.class;
    }

    @Override
    public MessageResponse handleEvent(MessageRequest request) {
        MessageSender sender = getSender(request);
        sender.send(request);
        return null;
    }

    protected MessageSender getSender(MessageRequest request) {
        if (request.getTrackingJSONData() == null)
            return senders.get(null);
        return senders.get(request.getTrackingJSONData().getStatus());
    }
}