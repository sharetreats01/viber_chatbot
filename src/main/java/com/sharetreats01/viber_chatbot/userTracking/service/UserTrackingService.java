package com.sharetreats01.viber_chatbot.userTracking.service;

import com.sharetreats01.viber_chatbot.userTracking.dto.UserActivityData;
import com.sharetreats01.viber_chatbot.userTracking.entity.UserActivityEntity;
import com.sharetreats01.viber_chatbot.userTracking.entity.UserSessionEntity;
import com.sharetreats01.viber_chatbot.userTracking.repository.UserTrackingRepository;
import com.sharetreats01.viber_chatbot.userTracking.utils.TrackingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserTrackingService {
    private final UserTrackingRepository repository;

    @Transactional
    public void insertActivity(UserActivityData data) {
        UserSessionEntity sessionEntity = repository.findById(data.getSessionId()).orElseGet(() -> createSession(data));
        UserActivityEntity activityEntity = new UserActivityEntity(sessionEntity, data.getEvent(), data.getEventData(), data.getEventTimestamp());
        sessionEntity.addActivity(activityEntity);
        repository.save(sessionEntity);
        log.info("activity: " + sessionEntity);
    }

    private UserSessionEntity createSession(UserActivityData data) {
        UserSessionEntity sessionEntity = new UserSessionEntity(TrackingUtils.createSessionId(), data.getUserId(), LocalDateTime.now());
        repository.save(sessionEntity);
        return sessionEntity;
    }
}
