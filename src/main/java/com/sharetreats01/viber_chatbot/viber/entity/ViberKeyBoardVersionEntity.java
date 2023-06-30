package com.sharetreats01.viber_chatbot.viber.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tb_viber_keyboad_version")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ViberKeyBoardVersionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "keyboard_id", nullable = false)
    private Integer keyBoardId;

    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
