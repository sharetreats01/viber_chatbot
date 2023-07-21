package com.sharetreats01.viber_chatbot.callback.entity;

import com.sharetreats01.viber_chatbot.botMessage.enums.TreatResult;
import com.sharetreats01.viber_chatbot.botMessage.enums.TreatConstant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tb_treat_message_template")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TreatMessageTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private TreatResult type;

    @Column(name = "constant", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private TreatConstant constant;

    @Column(name = "template", length = 255)
    private String template;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "version")
    private Integer version;
}
