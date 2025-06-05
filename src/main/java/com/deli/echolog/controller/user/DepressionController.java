package com.deli.echolog.controller.user;

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

import java.time.LocalDate;
import java.util.List;

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
        // 1. 기준이 되는 일기 하나 조회
        Diary diary = diaryService.getDiary(diaryId);

        // 2. 해당 사용자의 14일치 일기 조회
        Long memberId = diary.getMember().getId();
        LocalDate writtenDate = diary.getWrittenDate();
        List<Diary> diaryList = diaryService.getDiariesBy2weeks(memberId, writtenDate);

        // 3. 우울증 분석 수행 (여러 일기)
        Depression depression = depressionService.analyzeDepression(diaryList);

        // 4. 응답 DTO 변환 후 반환
        return ResponseEntity.ok(DepressionResponseDto.from(depression));
    }


    // 우울증 분석 수정
    @PutMapping("/{depressionId}")
    public ResponseEntity<DepressionResponseDto> updateDepression(@PathVariable Long depressionId
            , @RequestBody DepressionUpdateRequestDto depressionUpdateRequestDto) {
        // 수정함
        Depression depression = depressionService.updateDepression(depressionId, depressionUpdateRequestDto.getResult(), depressionUpdateRequestDto.getEmotionScore(),
                depressionUpdateRequestDto.getDepressionWordScore(), depressionUpdateRequestDto.getPhq9Score(), depressionUpdateRequestDto.getGad7Score());

        return ResponseEntity.ok(DepressionResponseDto.from(depression));
    }

    @DeleteMapping("/{depressionId}")
    public void deleteDepression(@PathVariable Long depressionId) {
        depressionService.deleteDepression(depressionId);
    }
}
