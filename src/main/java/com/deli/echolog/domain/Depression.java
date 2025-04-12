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
    Long id;

    // 분석한 일기
    @OneToOne(mappedBy = "depression")
    Diary diary;

    // 울울증 분석 내용
    @Column(columnDefinition = "TEXT")
    String content;

    // 생성일자
    LocalDateTime createDate;

    // 최종 수정일
    LocalDateTime updateDate;
}
