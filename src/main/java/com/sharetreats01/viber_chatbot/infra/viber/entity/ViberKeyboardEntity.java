package com.sharetreats01.viber_chatbot.infra.viber.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tb_viber_keyboard")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ViberKeyboardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "keyboard_type", length = 10, nullable = false)
    private String keyBoardType;

    @Column(name = "keyboard_desc", length = 50, nullable = false)
    private String keyBoardDesc;

    public ViberKeyboardEntity(String keyBoardType, String keyBoardDesc) {
        this.keyBoardDesc = keyBoardDesc;
    }
}
