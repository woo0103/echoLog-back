package com.deli.echolog.controller.user;

import com.deli.echolog.domain.Member;
import com.deli.echolog.dto.diary.DiaryListResponseDto;
import com.deli.echolog.dto.member.MemberCreateRequestDto;
import com.deli.echolog.dto.member.MemberResponseDto;
import com.deli.echolog.dto.member.MemberUpdateRequestDto;
import com.deli.echolog.service.LoginService;
import com.deli.echolog.service.MemberService;
import com.deli.echolog.util.AuthUtil;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;


    // 회원 조회 (사용자)
    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> getMember() {
        Long memberId = AuthUtil.getLoginMemberId();
        // 회원 찾아옴
        Member member = memberService.getMember(memberId);
        // Dto로 변환 후 반환
        return ResponseEntity.ok(MemberResponseDto.from(member));
    }

    // 회원 가입
    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody MemberCreateRequestDto memberCreateRequestDto) {
        Member member = memberCreateRequestDto.toEntity();
        memberService.createMember(member);
        return ResponseEntity.ok(MemberResponseDto.from(member));
    }

    // 회원 정보 수정
    @PutMapping()
    public ResponseEntity<MemberResponseDto> updateMember(@RequestBody MemberUpdateRequestDto memberUpdateRequestDto) {
        // 세션에서 찾아옴
        Long memberId = AuthUtil.getLoginMemberId();

        // 정보 수정
        Member member = memberService.updapteMember(
                memberId, memberUpdateRequestDto.getName(), memberUpdateRequestDto.getPassword(), memberUpdateRequestDto.getBirthDate(), memberUpdateRequestDto.getPhone()
        );
        return ResponseEntity.ok(MemberResponseDto.from(member));
    }


    // 회원 삭제
    @DeleteMapping()
    public void deleteMember() {
        Long memberId = AuthUtil.getLoginMemberId();
        memberService.deleteMember(memberId);
    }



}
