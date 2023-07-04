package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Message;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Sender;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class MessageRequest extends CallbackRequest {
    private Sender sender;
    private Message message;
}
