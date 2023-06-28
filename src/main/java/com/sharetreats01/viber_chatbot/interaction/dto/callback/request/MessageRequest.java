package com.sharetreats01.viber_chatbot.interaction.dto.callback.request;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Message;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.Sender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageRequest extends CallbackRequest {
    private Sender sender;
    private Message message;
}
