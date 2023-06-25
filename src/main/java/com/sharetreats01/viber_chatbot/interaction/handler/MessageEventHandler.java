package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.Callback;
import com.sharetreats01.viber_chatbot.interaction.enums.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageEventHandler implements CallbackEventHandler {
    @Override
    public Event getCallbackEvent() {
        return Event.MESSAGE;
    }

    @Override
    public Void handleEvent(Callback callback) {
        
        // swich로 event를 분류해서 진행 필요
        // TODO : Callback.Message.type 구분해서 분기로 진행
        // Message message = callback.buildMessage();
        return null;
    }



}
