package com.sharetreats01.viber_chatbot.viber.entity;

import com.sharetreats01.viber_chatbot.viber.enums.KeyboardType;
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
    @Enumerated
    private KeyboardType keyBoardType;

    @Column(name = "keyboard_desc", length = 50, nullable = false)
    private String keyBoardDesc;

    public ViberKeyboardEntity(KeyboardType keyBoardType, String keyBoardDesc) {
        this.keyBoardType = keyBoardType;
        this.keyBoardDesc = keyBoardDesc;
    }
}
