package com.deli.echolog.controller.user;

import com.deli.echolog.domain.Member;
import com.deli.echolog.dto.login.EmailExistResponseDto;
import com.deli.echolog.dto.login.LoginRequestDto;
import com.deli.echolog.dto.login.LoginResponseDto;
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
    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto) {
        String token = loginService.login(requestDto.getEmail(), requestDto.getPassword());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @GetMapping("/exist/{email}")
    public ResponseEntity<EmailExistResponseDto> emailExistValidate(@PathVariable String email) {
        Member member = memberService.findByEmail(email);
        if (member == null) {
            return ResponseEntity.ok(new EmailExistResponseDto(false));
        }
        return ResponseEntity.ok(new EmailExistResponseDto(true));
    }
}
