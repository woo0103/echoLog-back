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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // 생성, 수정일자
    @Embedded
    private BaseTime baseTime = new BaseTime();

    public void changeDiary(Diary diary) {
        this.diary = diary;
    }

    public void update(String content, UserReaction userReaction) {
        this.content = content;
        this.userReaction = userReaction;
    }

}
