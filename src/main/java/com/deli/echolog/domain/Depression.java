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

    // 생성일자
    private LocalDateTime createDate;

    // 최종 수정일
    private LocalDateTime updateDate;

    public void changeDiary(Diary diary) {
        this.diary = diary;
    }

    @PrePersist
    protected void onCreate() {
        if (this.createDate == null) {
            this.createDate = LocalDateTime.now();
        }
    }
}
