package com.deli.echolog.controller.user;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.DiaryFeedback;
import com.deli.echolog.dto.diaryFeedback.DiaryFeedbackResponseDto;
import com.deli.echolog.dto.diaryFeedback.DiaryFeedbackUpdateRequestDto;
import com.deli.echolog.service.DiaryFeedbackService;
import com.deli.echolog.service.DiaryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/diary-feedbacks")
public class DiaryFeedbackController {

    private final DiaryFeedbackService diaryFeedbackService;
    private final DiaryService diaryService;

    // 조회
    @GetMapping("/{diaryFeedbackId}")
    public ResponseEntity<DiaryFeedbackResponseDto> getDiaryFeedback(@PathVariable Long diaryFeedbackId) {
        // 일기 피드백 찾아옴
        DiaryFeedback diaryFeedback = diaryFeedbackService.getDiaryFeedback(diaryFeedbackId);
        // Dto로 변환 후 반환
        return ResponseEntity.ok(DiaryFeedbackResponseDto.from(diaryFeedback));
    }

    // 생성
    @PostMapping
    public ResponseEntity<DiaryFeedbackResponseDto> createDiaryFeedback(@RequestParam Long diaryId) {
        // 일기 찾아옴
        Diary diary = diaryService.getDiary(diaryId);
        // 일기 피드백 생성
        DiaryFeedback diaryFeedback = diaryFeedbackService.generateFeedback(diary);
        // Dto로 변환 후 반환
        return ResponseEntity.ok(DiaryFeedbackResponseDto.from(diaryFeedback));
    }

    // 수정
    @PutMapping("/{diaryFeedbackId}")
    public ResponseEntity<DiaryFeedbackResponseDto> updateDiaryFeedback(@PathVariable Long diaryFeedbackId
            , @RequestBody DiaryFeedbackUpdateRequestDto diaryFeedbackUpdateRequestDto) {
        // 일기 피드백 수정
        DiaryFeedback diaryFeedback = diaryFeedbackService.updateDiaryFeedback(diaryFeedbackId, diaryFeedbackUpdateRequestDto.getContent(), diaryFeedbackUpdateRequestDto.getUserReaction());
        // Dto로 변환 후 반환
        return ResponseEntity.ok(DiaryFeedbackResponseDto.from(diaryFeedback));
    }

    // 삭제
    @DeleteMapping("/{diaryFeedbackId}")
    public void deleteDiaryFeedback(@PathVariable Long diaryFeedbackId) {
        diaryFeedbackService.deleteDiaryFeedback(diaryFeedbackId);
    }
}
