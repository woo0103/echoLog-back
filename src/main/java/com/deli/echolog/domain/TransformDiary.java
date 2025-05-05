package com.deli.echolog.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "TRANSFORM_DIARY")
// 변환된 일기 엔티티
public class TransformDiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transform_diary_id")
    private Long id;

    // 원본 일기
    @OneToOne(mappedBy = "transformDiary")
    private Diary diary;

    // 변환된 일기 내용
    @Column(columnDefinition = "TEXT")
    private String content;
    // 생성, 수정일자
    @Embedded
    private BaseTime baseTime = new BaseTime();

    public void changeDiary(Diary diary) {
        this.diary = diary;
    }

    public void update(String content) {
        this.content = content;
    }


}
