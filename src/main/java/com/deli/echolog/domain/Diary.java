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
    private Long id;

    // 작성한 회원
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 일기 내용
    @Column(columnDefinition = "TEXT")
    private String content;

    // 생성일자
    private LocalDateTime createDate;
    // 최종 수정일
    private LocalDateTime updateDate;

    // 변환된 일기
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "transform_diary_id")
    private TransformDiary transformDiary;

    // 감정 분석
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "emotion_id")
    private Emotion emotion;

    // 일기 피드백
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "diary_feedback_id")
    private DiaryFeedback diaryFeedback;

    // 우울증 분석
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "depression_id")
    private Depression depression;

    public Diary() {
    }

    public Diary(String content) {
        this.content = content;
    }

    // member랑 연관관계 설정
    public void setMember(Member member) {
        this.member = member;
        if (member != null) {
            member.getDiaries().add(this);
        }
    }

    // depression이랑 연관관계 설정
    public void changeDepression(Depression depression) {
        this.depression = depression;
        if (depression != null) {
            depression.changeDiary(this);
        }
    }

    // emotion이랑 연관관계 설정
    public void changeEmotion(Emotion emotion) {
        this.emotion = emotion;
        if (emotion != null) {
            emotion.changeDiary(this);
        }
    }

    // 수정 할때 사용
    public void update(String content) {
        this.content = content;
        updateDate = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        if (this.createDate == null) {
            this.createDate = LocalDateTime.now();
        }
    }
}

