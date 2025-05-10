package com.deli.echolog.controller.user;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.Member;
import com.deli.echolog.dto.diary.DiaryCreateRequestDto;
import com.deli.echolog.dto.diary.DiaryListResponseDto;
import com.deli.echolog.dto.diary.DiaryResponseDto;
import com.deli.echolog.dto.diary.DiaryUpdateRequestDto;
import com.deli.echolog.service.DiaryService;
import com.deli.echolog.service.MemberService;
import com.deli.echolog.util.AuthUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/diaries")
public class DiaryController {

    // 생성자 주입
    private final DiaryService diaryService;

    // 일기 단건 조회
    @GetMapping("/{diaryId}")
    public ResponseEntity<DiaryResponseDto> getDiary(@PathVariable Long diaryId) {

        // 아이디로 일기 찾음
        Diary diary = diaryService.getDiary(diaryId);

        // DTO로 변환하고 반환
        return ResponseEntity.ok(DiaryResponseDto.from(diary));
    }


    // 모든 일기 목록 조회
    @GetMapping
    public ResponseEntity<Map<String, List<DiaryListResponseDto>>> getAllDiaries(@RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month) {
        // 세션에서 가져옴
        Long memberId = AuthUtil.getLoginMemberId();

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

    // 일기 저장
    @PostMapping
    public ResponseEntity<DiaryResponseDto> createDiary(@RequestParam boolean temp, @RequestBody DiaryCreateRequestDto diaryCreateRequestDto) {

        Long memberId = AuthUtil.getLoginMemberId();
        String content = diaryCreateRequestDto.getContent();
        LocalDate writtenDate = diaryCreateRequestDto.getWrittenDate();

        // 일기 생성 분석까지 해줌
        Diary diary = diaryService.createDiary(temp, memberId, content, writtenDate);

        // Dto로 변환하고 반환
        return ResponseEntity.ok(DiaryResponseDto.from(diary));
    }

    // 일기 수정
    @PutMapping("/{diaryId}")
    public ResponseEntity<DiaryResponseDto> updateDiary(@PathVariable Long diaryId, @RequestBody DiaryUpdateRequestDto diaryUpdateRequestDto) {
        // 일기 수정
        String content = diaryUpdateRequestDto.getContent();
        Diary diary = diaryService.updateDiary(diaryId, content);

        // Dto로 변환하고 반환
        return ResponseEntity.ok(DiaryResponseDto.from(diary));
    }

    // 일기 삭제
    @DeleteMapping("/{diaryId}")
    public void deleteDiary(@PathVariable Long diaryId) {
        diaryService.deleteDiary(diaryId);
    }


}
