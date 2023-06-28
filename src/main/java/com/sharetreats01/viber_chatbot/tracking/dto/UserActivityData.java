package com.sharetreats01.viber_chatbot.tracking.dto;

import com.sharetreats01.viber_chatbot.user.enums.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class UserActivityData {
    private UUID sessionId;
    private String userId;
    private Event event;
    private String eventData;
    private LocalDateTime eventTimestamp;
}
