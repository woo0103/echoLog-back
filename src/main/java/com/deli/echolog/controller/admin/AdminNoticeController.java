package com.deli.echolog.controller.admin;

import com.deli.echolog.service.NoticeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/admin/notice")
public class AdminNoticeController {

    private final NoticeService noticeService;

    // 공지사항 조회

    // 공지사항 작성

    // 공지사항 수정

    // 공지사항 삭제
}
