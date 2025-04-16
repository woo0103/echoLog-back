package com.deli.echolog.controller;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.Emotion;
import com.deli.echolog.dto.emotion.EmotionResponseDto;
import com.deli.echolog.dto.emotion.EmotionUpdateRequestDto;
import com.deli.echolog.service.DiaryService;
import com.deli.echolog.service.EmotionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/emotions")
public class EmotionController {

    private final EmotionService emotionService;
    private final DiaryService diaryService;

    @GetMapping("/{emotionId}")
    public ResponseEntity<EmotionResponseDto> getEmotion(@PathVariable Long emotionId) {
        // 감정 찾아옴
        Emotion emotion = emotionService.getEmotion(emotionId);
        // Dto로 변환 후 반환
        return ResponseEntity.ok(EmotionResponseDto.from(emotion));
    }

    // 감정 생성
    @PostMapping
    public ResponseEntity<EmotionResponseDto> createEmotion(@RequestParam Long diaryId) {
        // 일기 찾아옴
        Diary diary = diaryService.getDiary(diaryId);
        // 감정 분석함
        Emotion emotion = emotionService.createEmotion(diary);
        // 감정 반환
        return ResponseEntity.ok(EmotionResponseDto.from(emotion));
    }

    // 감정 수정
    @PutMapping("/{emotionId}")
    public ResponseEntity<EmotionResponseDto> updateEmotion(@PathVariable Long emotionId, @RequestBody EmotionUpdateRequestDto emotionUpdateRequestDto) {

        Emotion emotion = emotionService.updateEmotion(emotionId, emotionUpdateRequestDto.getEmotionType(), emotionUpdateRequestDto.getIntensity());
        // 반환함
        return ResponseEntity.ok(EmotionResponseDto.from(emotion));
    }

    @DeleteMapping("/{emotionId}")
    public void deleteEmotion(@PathVariable Long emotionId) {
        emotionService.deleteEmotion(emotionId);
    }
}
