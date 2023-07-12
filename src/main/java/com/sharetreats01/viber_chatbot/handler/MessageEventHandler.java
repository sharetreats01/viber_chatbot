package com.sharetreats01.viber_chatbot.handler;

import com.sharetreats01.viber_chatbot.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.dto.callback.request.property.State;
import com.sharetreats01.viber_chatbot.dto.callback.response.MessageResponse;
import com.sharetreats01.viber_chatbot.util.TrackingDataUtils;
import com.sharetreats01.viber_chatbot.infra.viber.sender.MessageSender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MessageEventHandler implements CallbackEventHandler<MessageRequest, MessageResponse> {
    private final Map<State, MessageSender> senders;

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
        String trackingData = request.getMessage().getTrackingData();
        String userReply = request.getMessage().getText();

        return senders.get(TrackingDataUtils.getStateWithReplyText(trackingData,userReply));
    }
}