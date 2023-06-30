package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Tracking;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.MessageResponse;
import com.sharetreats01.viber_chatbot.interaction.handler.processor.MessageTrackingProcessor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MessageEventHandler implements CallbackEventHandler<MessageRequest, MessageResponse> {
    private final Map<Tracking, MessageTrackingProcessor> processors;

    public MessageEventHandler(List<MessageTrackingProcessor> processorList) {
        this.processors = processorList.stream().collect(Collectors.toMap(MessageTrackingProcessor::getTrackingType, Function.identity()));
    }

    @Override
    public Class<MessageRequest> getCallbackType() {
        return MessageRequest.class;
    }

    @Override
    public MessageResponse handleEvent(MessageRequest request) {
        Tracking tracking = Tracking.fromTrackingData(request.getTrackingData());
        MessageTrackingProcessor processor = processors.get(tracking);
        processor.process(request);
        return null;
    }

    public void brandKeyboarMessage() {
        return ;
    }
    public void ProductAvailableMessage() {
        //productId를 이용해서 DTO 만들기
        return null;
    }
}
