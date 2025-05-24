package com.deli.echolog.controller.admin;

import com.deli.echolog.domain.Member;
import com.deli.echolog.domain.Notice;
import com.deli.echolog.domain.Role;
import com.deli.echolog.dto.diary.DiaryResponseDto;
import com.deli.echolog.dto.member.MemberResponseDto;
import com.deli.echolog.dto.notice.NoticeCreateRequestDto;
import com.deli.echolog.dto.notice.NoticeListResponseDto;
import com.deli.echolog.dto.notice.NoticeResponseDto;
import com.deli.echolog.exception.AdminAccessDeniedException;
import com.deli.echolog.service.MemberService;
import com.deli.echolog.service.NoticeService;
import com.deli.echolog.util.AuthUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/admin/notices")
public class AdminNoticeController {

    private final NoticeService noticeService;
    private final MemberService memberService;

    // 공지사항 단건 조회
    @GetMapping("/{noticeId}")
    public ResponseEntity<NoticeResponseDto> getNotice(@PathVariable Long noticeId) {
        validateAdminSession();
        // 아이디로 공지 찾아옴
        Notice notice = noticeService.getNotice(noticeId);
        // Dto로 변환하고 반환
        return ResponseEntity.ok(NoticeResponseDto.from(notice));

    }

    // 공지사항 목록 조회
    // 회원 목록 조회
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllNotices(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        validateAdminSession();
        Page<Notice> noticerPage = noticeService.getAllNotice(PageRequest.of(page, size));

        List<NoticeListResponseDto> responseNotices = noticerPage.stream()
                .map(NoticeListResponseDto::from)
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("notices", responseNotices);
        response.put("currentPage", noticerPage.getNumber());
        response.put("totalPages", noticerPage.getTotalPages());
        response.put("totalElements", noticerPage.getTotalElements());

        return ResponseEntity.ok(response);
    }


    // 공지사항 작성
    @PostMapping
    public ResponseEntity<NoticeResponseDto> createNotice(@RequestBody NoticeCreateRequestDto noticeCreateRequestDto) {
        validateAdminSession();
        Long memberId = AuthUtil.getLoginMemberId();

        String writer = memberService.getMember(memberId).getName();
        String title = noticeCreateRequestDto.getTitle();
        String content = noticeCreateRequestDto.getContent();


        Notice notice = noticeService.createNotice(new Notice(title, content, writer));
        return ResponseEntity.ok(NoticeResponseDto.from(notice));

    }

    // 공지사항 수정
    @PutMapping("/{noticeId}")
    public ResponseEntity<NoticeResponseDto> updateNotice(@PathVariable Long noticeId, @RequestBody NoticeCreateRequestDto noticeCreateRequestDto) {
        validateAdminSession();
        Long memberId = AuthUtil.getLoginMemberId();

        String writer = memberService.getMember(memberId).getName();
        String title = noticeCreateRequestDto.getTitle();
        String content = noticeCreateRequestDto.getContent();


        Notice notice = noticeService.updateNotice(noticeId, title, content, writer);
        return ResponseEntity.ok(NoticeResponseDto.from(notice));

    }

    // 공지사항 삭제
    @DeleteMapping("/{noticeId}")
    public void deleteNotice(@PathVariable Long noticeId) {
        validateAdminSession();
        noticeService.deleteNotice(noticeId);
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
