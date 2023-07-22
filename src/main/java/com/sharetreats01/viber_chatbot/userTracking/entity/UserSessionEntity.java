package com.sharetreats01.viber_chatbot.userTracking.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Entity
@Table(name = "tb_user_session")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSessionEntity {
    @Id
    @Column(name = "session_id", columnDefinition = "BINARY(16)")
    private UUID sessionId;

    @Column(name = "user_id", nullable = false, length = 255)
    private String userId;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private final List<UserActivityEntity> userActivityEntities = new ArrayList<>();

    public UserSessionEntity(UUID sessionId, String userId, LocalDateTime startTime) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.startTime = startTime;
    }

    public void addActivity(UserActivityEntity entity) {
        this.userActivityEntities.add(entity);
    }

    public void addActivity(List<UserActivityEntity> entities) {
        this.userActivityEntities.addAll(entities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSessionEntity that = (UserSessionEntity) o;

        if (!sessionId.equals(that.sessionId)) return false;
        if (!userId.equals(that.userId)) return false;
        if (!startTime.equals(that.startTime)) return false;
        if (!Objects.equals(endTime, that.endTime)) return false;
        return Objects.equals(userActivityEntities, that.userActivityEntities);
    }

    @Override
    public int hashCode() {
        int result = sessionId.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + startTime.hashCode();
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + userActivityEntities.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserSessionEntity{" +
                "sessionId=" + sessionId +
                ", userId='" + userId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", userActivityEntities=" + userActivityEntities +
                '}';
    }
}
