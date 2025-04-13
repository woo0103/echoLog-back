package com.deli.echolog.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "DIARY_FEEDBACK")
// 일기 피드백 엔티티
public class DiaryFeedback {

    @Id
    @GeneratedValue
    @Column(name = "diary_feedback_id")
    private Long id;

    // 피드백 한 일기
    @OneToOne(mappedBy = "diaryFeedback")
    private Diary diary;

    // 피드백 내용
    @Column(columnDefinition = "TEXT")
    private String content;

    // 피드백에대한 사용자 평가
    @Enumerated(value = EnumType.STRING)
    private UserReaction userReaction;

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
