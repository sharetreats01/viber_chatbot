package com.sharetreats01.viber_chatbot.viber.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tb_viber_keyboard_version")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ViberKeyBoardVersionEntity {
    @Id
    private Integer id;

    @Column(name = "keyboard_id", nullable = false)
    private Integer keyBoardId;

    @Column(name = "keyboard_version", nullable = false)
    private Integer version;

    @Column(name = "data", columnDefinition = "TEXT", nullable = false)
    private String data;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
