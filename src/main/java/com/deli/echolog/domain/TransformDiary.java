package com.deli.echolog.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSFORM_DIARY")
// 변환된 일기 엔티티
public class TransformDiary {
    @Id
    @GeneratedValue
    @Column(name = "transform_diary_id")
    private Long id;

    // 원본 일기
    @OneToOne(mappedBy = "transformDiary")
    Diary diary;

    // 변환된 일기 내용
    @Column(columnDefinition = "TEXT")
    String content;
    // 생성일자
    LocalDateTime createDate;
    // 최종 수정일
    LocalDateTime updateDate;

}
