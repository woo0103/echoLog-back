package com.deli.echolog.controller;

import com.deli.echolog.domain.Member;
import com.deli.echolog.dto.member.MemberCreateRequestDto;
import com.deli.echolog.dto.member.MemberResponseDto;
import com.deli.echolog.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    // 회원 가입
    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody MemberCreateRequestDto memberCreateRequestDto) {
        Member member = memberCreateRequestDto.toEntity();
        memberService.createMember(member);
        return ResponseEntity.ok(MemberResponseDto.from(member));
    }
}
