package com.sharetreats01.viber_chatbot.user.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_message")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "modifiedAt")
    private LocalDateTime modifiedAt;
}
