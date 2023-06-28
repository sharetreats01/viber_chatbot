package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.MessageRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.MessageResponse;
import com.sharetreats01.viber_chatbot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageEventHandler implements CallbackEventHandler<MessageRequest, MessageResponse> {
    private final UserService userService;

    @Override
    public Class<MessageRequest> getCallbackType() {
        return MessageRequest.class;
    }

    @Override
    public MessageResponse handleEvent(MessageRequest request) {
        // swich로 event를 분류해서 진행 필요
        // TODO : Callback.Message.type 구분해서 분기로 진행
        // Message message = callback.buildMessage();
        return null;
    }



}
