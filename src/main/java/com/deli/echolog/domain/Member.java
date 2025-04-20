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
    private Long id;

    // 이름(길이제한 50)
    @Column(length = 50)
    private String name;
    // 이메일(로그인할때 아이디로 씀)
    private String email;
    // 비번
    private String password;

    // 역할(관리자, 사용자 구분)
    @Enumerated(EnumType.STRING)
    private Role role;
    // 생년월일
    private LocalDate birthDate;
    // 폰번호
    @Column(length = 20)
    private String phone;

    // 작성한 일기 목록
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Diary> diaries = new ArrayList<>();

    // 생성, 수정일자
    @Embedded
    private BaseTime baseTime = new BaseTime();

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

    public void update(String name, String password, LocalDate birthDate, String phone) {
        this.name = name;
        this.password = password;
        this.birthDate = birthDate;
        this.phone = phone;
    }


}
