package com.deli.echolog.controller.user;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.TransformDiary;
import com.deli.echolog.dto.transformDiary.TransformDiaryResponseDto;
import com.deli.echolog.dto.transformDiary.TransformDiaryUpdateRequestDto;
import com.deli.echolog.service.DiaryService;
import com.deli.echolog.service.TransformDiaryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/transform-diaries")
public class TransformDiaryController {

    private final TransformDiaryService transformDiaryService;
    private final DiaryService diaryService;

    // 조회
    @GetMapping("/{transformDiaryId}")
    public ResponseEntity<TransformDiaryResponseDto> getTransformDiary(@PathVariable Long transformDiaryId) {
        // 변환된 일기 찾아옴
        TransformDiary transformDiary = transformDiaryService.getTransformDiary(transformDiaryId);
        // Dto로 변환 후 반환
        return ResponseEntity.ok(TransformDiaryResponseDto.from(transformDiary));
    }

    // 생성
    @PostMapping
    public ResponseEntity<TransformDiaryResponseDto> createTransformDiary(@RequestParam Long diaryId) {
        // 일기 찾아옴
        Diary diary = diaryService.getDiary(diaryId);
        // 일기 변환
        TransformDiary transformDiary = transformDiaryService.transform(diary);
        // 반환
        return ResponseEntity.ok(TransformDiaryResponseDto.from(transformDiary));
    }

    // 수정
    @PutMapping("/{transformDiaryId}")
    public ResponseEntity<TransformDiaryResponseDto> updateTransformDiary(@PathVariable Long transformDiaryId
            , @RequestBody TransformDiaryUpdateRequestDto transformDiaryUpdateRequestDto) {

        TransformDiary transformDiary = transformDiaryService.updateTransformDiary(transformDiaryId, transformDiaryUpdateRequestDto.getContent());

        // 일기 다시 분석
        Diary diary = diaryService.getDiaryByTransformDiaryId(transformDiaryId);
        diaryService.analyzeDiary(diary, transformDiary);

        return ResponseEntity.ok(TransformDiaryResponseDto.from(transformDiary));
    }

    // 삭제
    @DeleteMapping("/{transformDiaryId}")
    public void deleteTransformDiary(@PathVariable Long transformDiaryId) {
        transformDiaryService.deleteTransformDiary(transformDiaryId);
    }
}
