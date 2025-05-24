package com.deli.echolog.service;

import com.deli.echolog.domain.Member;
import com.deli.echolog.exception.DiaryNotFoundException;
import com.deli.echolog.exception.MemberNotFoundException;
import com.deli.echolog.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class MemberService {

    // 생성자 주입
    private final MemberRepository memberRepository;

    // 회원 조회
    @Transactional(readOnly = true)
    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("member not found"));
    }

    @Transactional(readOnly = true)
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElse(null);
    }

    // 전체 회원 조회
    public Page<Member> getAllMembers(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }


    // 회원 가입
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    // 회원 정보 수정
    public Member updapteMember(Long memberId, String name, String password, LocalDate birthDate, String phone) {
        Member member = getMember(memberId);
        member.update(name, password, birthDate, phone);
        return member;
    }

    // 회원 탈퇴
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
