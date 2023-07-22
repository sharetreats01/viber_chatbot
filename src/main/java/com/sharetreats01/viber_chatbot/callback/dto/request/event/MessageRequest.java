package com.sharetreats01.viber_chatbot.callback.dto.request.event;

import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.Sender;
import com.sharetreats01.viber_chatbot.callback.dto.request.event.property.Message;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class MessageRequest extends CallbackRequest {
    private Sender sender;
    private Message message;
}
