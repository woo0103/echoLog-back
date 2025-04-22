package com.deli.echolog.service;

import com.deli.echolog.domain.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class LoginService {

    private final MemberService memberService;

    public Member login(String email, String password) {
        Member member = memberService.findByEmail(email);
        if (member == null) {
            throw new IllegalArgumentException("존재하지 않는 이메일입니다.");
        }

        if (!member.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }


        return member;
    }


}
