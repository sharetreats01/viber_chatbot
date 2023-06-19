package com.sharetreats01.viber_chatbot.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ConversationStarted {
    private final String event;
    private final long timestamp;
    private final long messageToken;
    private final String type;
    private final String context;
    private final User user;
    private final boolean subscribed;
}
