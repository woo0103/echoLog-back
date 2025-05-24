package com.deli.echolog.controller.user;

import com.deli.echolog.domain.Notice;
import com.deli.echolog.dto.notice.NoticeListResponseDto;
import com.deli.echolog.dto.notice.NoticeResponseDto;
import com.deli.echolog.service.NoticeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/notices")
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllNotices(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

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
}
