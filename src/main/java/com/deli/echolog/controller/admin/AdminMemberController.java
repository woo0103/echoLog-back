package com.deli.echolog.controller.admin;


import com.deli.echolog.domain.Member;
import com.deli.echolog.domain.Role;
import com.deli.echolog.dto.member.MemberResponseDto;
import com.deli.echolog.dto.member.MemberUpdateRequestDto;
import com.deli.echolog.exception.AdminAccessDeniedException;
import com.deli.echolog.service.MemberService;
import com.deli.echolog.util.AuthUtil;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/admin/members")
public class AdminMemberController {

    private final MemberService memberService;

    // 회원 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable Long memberId) {
        validateAdminSession();
        // 회원 찾아옴
        Member member = memberService.getMember(memberId);
        // Dto로 변환 후 반환
        return ResponseEntity.ok(MemberResponseDto.from(member));
    }

    // 회원 목록 조회
    @GetMapping
    public ResponseEntity<Map<String, List<MemberResponseDto>>> getAllMembers() {
        validateAdminSession();
        List<Member> members = memberService.getAllMembers();
        List<MemberResponseDto> responseMembers = new ArrayList<>();

        for (Member member : members) {
            responseMembers.add(MemberResponseDto.from(member));
        }

        Map<String, List<MemberResponseDto>> response = new HashMap<>();
        response.put("members", responseMembers);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto memberUpdateRequestDto) {
        validateAdminSession();

        // 정보 수정
        Member member = memberService.updapteMember(
                memberId, memberUpdateRequestDto.getName(), memberUpdateRequestDto.getPassword(), memberUpdateRequestDto.getBirthDate(), memberUpdateRequestDto.getPhone()
        );
        return ResponseEntity.ok(MemberResponseDto.from(member));
    }

    // 관리자가 요청한게 맞는지 확인하는 메서드임
    private void validateAdminSession() {
        Long loginMemberId = AuthUtil.getLoginMemberId();
        Member member = memberService.getMember(loginMemberId);

        if (member.getRole() != Role.ADMIN) {
            throw new AdminAccessDeniedException("관리자 권환이 필요합니다.");
        }
    }
}
