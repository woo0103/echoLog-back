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
    @GeneratedValue
    @Column(name = "depression_id")
    private Long id;

    // 분석한 일기
    @OneToOne(mappedBy = "depression")
    private Diary diary;

    // 우울증 분석 내용
    @Column(columnDefinition = "TEXT")
    private String content;

    // 감정 점수
    private Double emotionScore;

    // 우울 단어 점수
    private double depressionWordScore;

    // phq9 점수
    private double phq9Score;

    // 생성일자
    private LocalDateTime createDate;

    // 최종 수정일
    private LocalDateTime updateDate;

    public void changeDiary(Diary diary) {
        this.diary = diary;
    }

    public void update(String content, Double emotionScore, Double depressionWordScore, Double phq9Score) {
        this.content = content;
        this.emotionScore = emotionScore;
        this.depressionWordScore = depressionWordScore;
        this.phq9Score = phq9Score;
    }



    @PrePersist
    protected void onCreate() {
        if (this.createDate == null) {
            this.createDate = LocalDateTime.now();
        }
    }
}
