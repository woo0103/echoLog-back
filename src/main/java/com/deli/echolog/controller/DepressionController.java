package com.deli.echolog.controller;

import com.deli.echolog.domain.Depression;
import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.Member;
import com.deli.echolog.dto.depression.DepressionResponseDto;
import com.deli.echolog.dto.depression.DepressionUpdateRequestDto;
import com.deli.echolog.service.DepressionService;
import com.deli.echolog.service.DiaryService;
import com.deli.echolog.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/depressions")
public class DepressionController {

    private final DepressionService depressionService;
    private final DiaryService diaryService;

    // 우울증 분석 조회
    @GetMapping("{depressionId}")
    public ResponseEntity<DepressionResponseDto> getDepression(@PathVariable Long depressionId) {
        // 우울증 분석 찾아옴
        Depression depression = depressionService.getDepression(depressionId);
        // Dto로 변환 후 반환
        return ResponseEntity.ok(DepressionResponseDto.from(depression));
    }

    // 우울증 분석 생성
    @PostMapping
    public ResponseEntity<DepressionResponseDto> createDepression(@RequestParam Long diaryId) {
        // 일기 찾아옴
        Diary diary = diaryService.getDiary(diaryId);
        // 일기에 대한 우울증 분석 생성
        Depression depression = depressionService.analyzeDepression(diary);
        // 우울증 분석 결과 반환
        return ResponseEntity.ok(DepressionResponseDto.from(depression));
    }

    // 우울증 분석 수정
    @PutMapping("/{depressionId}")
    public ResponseEntity<DepressionResponseDto> updateDepression(@PathVariable Long depressionId
            , @RequestBody DepressionUpdateRequestDto depressionUpdateRequestDto) {
        // 수정함
        Depression depression = depressionService.updateDepression(depressionId, depressionUpdateRequestDto.getContent(), depressionUpdateRequestDto.getEmotionScore(),
                depressionUpdateRequestDto.getDepressionWordScore(), depressionUpdateRequestDto.getPhq9Score(), depressionUpdateRequestDto.getGad7Score());

        return ResponseEntity.ok(DepressionResponseDto.from(depression));
    }

    @DeleteMapping("/{depressionId}")
    public void deleteDepression(@PathVariable Long depressionId) {
        depressionService.deleteDepression(depressionId);
    }
}
