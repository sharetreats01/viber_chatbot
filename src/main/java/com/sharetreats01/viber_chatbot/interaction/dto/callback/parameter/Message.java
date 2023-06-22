package com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter;

import com.sharetreats01.viber_chatbot.interaction.enums.Type;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Message {
    private final Type type;
    private final String text;
    private final String media;
    private final Location location;
    private final Contact contact;
    private final String tracking_data;
    private final String fileName;
    private final Integer fileSize;
    private final Integer duration;
    private final Integer stickerId;
}
