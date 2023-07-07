package com.sharetreats01.viber_chatbot.infra.sharetreats.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "tb_sharetreats_brand")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ShareTreatsBrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private ShareTreatsCategoryEntity category;

    @Column(name = "brand_name", length = 100, nullable = false)
    private String brandName;

    @Column(name = "brand_image", length = 255)
    private String brandImage;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    @ToString.Exclude
    private List<ShareTreatsProductEntity> productEntities = new ArrayList<>();

    public ShareTreatsBrandEntity(ShareTreatsCategoryEntity category, String brandName, String brandImage) {
        this.category = category;
        this.brandName = brandName;
        this.brandImage = brandImage;
    }
}
