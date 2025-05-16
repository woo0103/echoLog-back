package com.deli.echolog.controller.admin;


import com.deli.echolog.domain.Diary;
import com.deli.echolog.dto.diary.DiaryListResponseDto;
import com.deli.echolog.service.DiaryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/admin/diaries")
public class AdminDiaryController {

    private final DiaryService diaryService;

    @GetMapping
    public ResponseEntity<Map<String, List<DiaryListResponseDto>>> getAllDiaries(@RequestParam Long memberId, @RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month) {

        // year 또는 month가 null이면 현재 날짜 기준으로 설정
        LocalDate now = LocalDate.now();
        int resolvedYear = (year != null) ? year : now.getYear();
        int resolvedMonth = (month != null) ? month : now.getMonthValue();

        // 일기 목록 가져옴
        List<Diary> diaries = diaryService.getDiariesByMonth(memberId, resolvedYear, resolvedMonth);

        // 일기 없으면 빈 리스트 넣어줌(null 체크)
        if (diaries == null) {
            diaries = new ArrayList<>();
        }

        // 일기 리스트를 Dto 리스트로 변환
        List<DiaryListResponseDto> responseDiaries = new ArrayList<>();
        for (Diary diary : diaries) {
            responseDiaries.add(DiaryListResponseDto.from(diary));
        }

        Map<String, List<DiaryListResponseDto>> response = new HashMap<>();
        response.put("diaries", responseDiaries);
        return ResponseEntity.ok(response);
    }

}
