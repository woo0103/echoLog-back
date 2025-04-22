package com.deli.echolog.controller;

import com.deli.echolog.domain.Member;
import com.deli.echolog.dto.diary.DiaryListResponseDto;
import com.deli.echolog.dto.member.MemberCreateRequestDto;
import com.deli.echolog.dto.member.MemberResponseDto;
import com.deli.echolog.dto.member.MemberUpdateRequestDto;
import com.deli.echolog.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
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

    // 회원 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable Long memberId) {
        // 회원 찾아옴
        Member member = memberService.getMember(memberId);
        // Dto로 변환 후 반환
        return ResponseEntity.ok(MemberResponseDto.from(member));
    }

    @GetMapping
    public ResponseEntity<Map<String, List<MemberResponseDto>>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        List<MemberResponseDto> responseMembers = new ArrayList<>();

        for (Member member : members) {
            responseMembers.add(MemberResponseDto.from(member));
        }

        Map<String, List<MemberResponseDto>> response = new HashMap<>();
        response.put("members", responseMembers);
        return ResponseEntity.ok(response);

    }

    // 회원 가입
    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody MemberCreateRequestDto memberCreateRequestDto) {
        Member member = memberCreateRequestDto.toEntity();
        memberService.createMember(member);
        return ResponseEntity.ok(MemberResponseDto.from(member));
    }

    // 회원 정보 수정
    @PutMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto memberUpdateRequestDto) {
        // 정보 수정
        Member member = memberService.updapteMember(
                memberId, memberUpdateRequestDto.getName(), memberUpdateRequestDto.getPassword(), memberUpdateRequestDto.getBirthDate(), memberUpdateRequestDto.getPhone()
        );
        return ResponseEntity.ok(MemberResponseDto.from(member));
    }

    // 삭제
    /*@DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
    }*/

    @DeleteMapping()
    public void deleteMember(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long memberId = (Long) session.getAttribute("LOGIN_MEMBER_ID");
        memberService.deleteMember(memberId);
    }

}
