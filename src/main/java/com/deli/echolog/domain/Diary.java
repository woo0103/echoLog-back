package com.deli.echolog.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "DIARY")
// 일기 엔티티
public class Diary {

    @Id
    @GeneratedValue
    @Column(name = "diary_id")
    Long id;

    // 작성한 회원
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;

    // 일기 내용
    @Column(columnDefinition = "TEXT")
    String content;

    // 생성일자
    LocalDateTime createDate;
    // 최종 수정일
    LocalDateTime updateDate;

    // 변환된 일기
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transform_diary_id")
    TransformDiary transformDiary;

    // 감정 분석
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emotion_id")
    Emotion emotion;

    // 일기 피드백
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_feedback_id")
    DiaryFeedback diaryFeedback;

    // 우울증 분석
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depression_id")
    Depression depression;
}
