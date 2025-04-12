package com.deli.echolog.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "MEMBER")
// 회원 엔티티
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    Long id;

    // 이름(길이제한 50)
    @Column(length = 50)
    String name;
    // 이메일(로그인할때 아이디로 씀)
    String email;
    // 비번
    String password;

    // 역할(관리자, 사용자 구분)
    @Enumerated(EnumType.STRING)
    Role role;
    // 생년월일
    LocalDate birthDate;
    // 폰번호
    @Column(length = 20)
    String phone;

    // 작성한 일기 목록
    @OneToMany(mappedBy = "member")
    List<Diary> diaries = new ArrayList<>();

    // 생성일자
    LocalDateTime createDate;
    // 최종 수정일
    LocalDateTime updateDate;

    public Member() {
    }

    public Member(String name, String email, String password, Role role, LocalDate birthDate, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    // 생성일자 넣는거
    @PrePersist
    protected void onCreate() {
        if (this.createDate == null) {
            this.createDate = LocalDateTime.now();
        }
    }




}
