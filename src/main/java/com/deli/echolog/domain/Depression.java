package com.deli.echolog.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "DEPRESSION")
// 우울증 분석 엔티티
public class Depression {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depression_id")
    private Long id;

    // 분석한 일기
    @OneToOne(mappedBy = "depression")
    private Diary diary;

    // 우울증 분석 내용
    private Boolean result;

    // 감정 점수
    private double emotionScore;

    // 우울 단어 점수
    private double depressionWordScore;

    // phq9 점수
    private double phq9Score;

    // GAD-7 점수
    private double gad7Score;

    // 생성, 수정일자
    @Embedded
    private BaseTime baseTime = new BaseTime();

    public void changeDiary(Diary diary) {
        this.diary = diary;
    }

    public void update(Boolean result, Double emotionScore, Double depressionWordScore, Double phq9Score, Double gad7Score) {
        this.result = result;
        this.emotionScore = emotionScore;
        this.depressionWordScore = depressionWordScore;
        this.phq9Score = phq9Score;
        this.gad7Score = gad7Score;
    }

}
