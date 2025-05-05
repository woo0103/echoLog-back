package com.deli.echolog.controller.user;

import com.deli.echolog.domain.Member;
import com.deli.echolog.dto.login.LoginRequestDto;
import com.deli.echolog.service.LoginService;
import com.deli.echolog.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/auth")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {
        String email = loginRequestDto.getEmail();
        String password = loginRequestDto.getPassword();
        Member loginMember = loginService.login(email, password);

        // 로그인 실패시 예외
        if (loginMember == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }

        HttpSession session = request.getSession();
        session.setAttribute("LOGIN_MEMBER_ID", loginMember.getId());
        return ResponseEntity.ok("로그인 성공");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok("로그아웃 성공");
    }
}
