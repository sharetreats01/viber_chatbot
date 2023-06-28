package com.sharetreats01.viber_chatbot.tracking.entity;

import com.sharetreats01.viber_chatbot.user.enums.Event;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tb_user_activity")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private UserSessionEntity sessionEntity;

    @Enumerated
    @Column(name = "event_type", length = 10, nullable = false)
    private Event event;

    @Column(name = "event_data", length = 50, nullable = false)
    private String eventData;

    @Column(name = "event_timestamp", nullable = false)
    private LocalDateTime eventTimeStamp;


    public UserActivityEntity(UserSessionEntity sessionEntity, Event event, String eventData, LocalDateTime eventTimeStamp) {
        this.sessionEntity = sessionEntity;
        this.event = event;
        this.eventData = eventData;
        this.eventTimeStamp = eventTimeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserActivityEntity that = (UserActivityEntity) o;

        if (!id.equals(that.id)) return false;
        if (!sessionEntity.equals(that.sessionEntity)) return false;
        if (event != that.event) return false;
        if (!eventData.equals(that.eventData)) return false;
        return eventTimeStamp.equals(that.eventTimeStamp);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + sessionEntity.hashCode();
        result = 31 * result + event.hashCode();
        result = 31 * result + eventData.hashCode();
        result = 31 * result + eventTimeStamp.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserActivityEntity{" +
                "id=" + id +
                ", sessionEntity=" + sessionEntity +
                ", event=" + event +
                ", eventData='" + eventData + '\'' +
                ", eventTimeStamp=" + eventTimeStamp +
                '}';
    }
}
