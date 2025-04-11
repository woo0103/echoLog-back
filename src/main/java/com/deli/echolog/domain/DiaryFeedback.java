package com.deli.echolog.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "DIARY_FEEDBACK")
// 일기 피드백 엔티티
public class DiaryFeedback {

    @Id
    @GeneratedValue
    @Column(name = "diary_feedback_id")
    Long id;

    // 피드백 한 일기
    @OneToOne(mappedBy = "diaryFeedback")
    Diary diary;

    // 피드백 내용
    @Column(columnDefinition = "TEXT")
    String content;

    // 피드백에대한 사용자 평가
    @Enumerated(value = EnumType.STRING)
    UserReaction userReaction;

    // 생성일자
    LocalDateTime createDate;
    // 최종 수정일
    LocalDateTime updateDate;
}
