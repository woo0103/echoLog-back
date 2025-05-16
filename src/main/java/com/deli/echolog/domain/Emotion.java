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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emotion_id")
    private Long id;

    // 분석한 일기
    @OneToOne(mappedBy = "emotion")
    private Diary diary;
    // 감정 타입(6개중 하나)
    @Enumerated(EnumType.STRING)
    private EmotionType emotionType;

    // 생성, 수정일자
    @Embedded
    private BaseTime baseTime = new BaseTime();

    public void update(EmotionType emotionType) {
        this.emotionType = emotionType;
    }

    public void changeDiary(Diary diary) {
        this.diary = diary;
    }

}
