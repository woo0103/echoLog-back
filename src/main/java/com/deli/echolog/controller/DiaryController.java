package com.deli.echolog.controller;

import com.deli.echolog.service.DiaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class DiaryController {

    // 생성자 주입
    private final DiaryService diaryService;
}
