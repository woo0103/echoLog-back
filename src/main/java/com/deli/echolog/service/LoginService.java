package com.deli.echolog.service;

import com.deli.echolog.domain.Member;
import com.deli.echolog.domain.Role;
import com.deli.echolog.jwt.JwtTokenProvider;
import com.deli.echolog.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class LoginService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public String login(String email, String password) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 이메일입니다."));

        if (!member.getPassword().equals(password)) {
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }

        // 로그인 성공 시 JWT 발급
        return jwtTokenProvider.createToken(member.getId(), member.getRole().name());
    }
}
