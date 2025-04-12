package com.deli.echolog.service;

import com.deli.echolog.domain.Member;
import com.deli.echolog.exception.DiaryNotFoundException;
import com.deli.echolog.exception.MemberNotFoundException;
import com.deli.echolog.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    // 생성자 주입
    private final MemberRepository memberRepository;

    // 회원 조회
    public Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("member not found"));
    }

    // 회원 생성
    @Transactional
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }
}
