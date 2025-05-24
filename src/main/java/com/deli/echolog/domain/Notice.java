package com.deli.echolog.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "NOTICE")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    // 제목
    String title;
    // 내용
    String content;
    // 작성자 이름
    String writer;

    // 생성, 수정일자
    @Embedded
    private BaseTime baseTime = new BaseTime();

    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
