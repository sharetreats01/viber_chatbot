package com.sharetreats01.viber_chatbot.viber.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public final class SetWebhookRequest {
    private final String url;
    private final List<String> eventTypes;
    private final Boolean sendName;
    private final Boolean sendPhoto;
}
