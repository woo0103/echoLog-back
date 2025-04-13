package com.deli.echolog.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "EMOTION")
// 감정 분석 엔티티
public class Emotion {

    @Id
    @GeneratedValue
    @Column(name = "emotion_id")
    private Long id;

    // 분석한 일기
    @OneToOne(mappedBy = "emotion")
    private Diary diary;
    // 감정 타입(6개중 하나)
    private String type;
    // 감정 강도
    private Double intensity;
    // 생성일자
    private LocalDateTime createDate;
    // 최종 수정일
    private LocalDateTime updateDate;

    @PrePersist
    protected void onCreate() {
        if (this.createDate == null) {
            this.createDate = LocalDateTime.now();
        }
    }
}
