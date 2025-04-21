package com.deli.echolog.service;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.DiaryFeedback;
import com.deli.echolog.domain.EmotionType;
import com.deli.echolog.domain.UserReaction;
import com.deli.echolog.dto.diaryFeedback.DiaryFeedbackJsonRequestDto;
import com.deli.echolog.dto.diaryFeedback.DiaryFeedbackJsonResponseDto;
import com.deli.echolog.exception.DiaryFeedbackNotFoundException;
import com.deli.echolog.repository.DiaryFeedbackRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class DiaryFeedbackService {

    private final DiaryFeedbackRepository diaryFeedbackRepository;

    // 조회
    @Transactional(readOnly = true)
    public DiaryFeedback getDiaryFeedback(Long diaryFeedbackId) {
        return diaryFeedbackRepository.findById(diaryFeedbackId)
                .orElseThrow(() -> new DiaryFeedbackNotFoundException("diaryFeedback not found"));
    }

    // 저장
    public DiaryFeedback saveDiaryFeedback(DiaryFeedback diaryFeedback) {
        return diaryFeedbackRepository.save(diaryFeedback);
    }

    // 수정
    public DiaryFeedback updateDiaryFeedback(Long diaryFeedbackId, String content, UserReaction userReaction) {
        DiaryFeedback diaryFeedback = getDiaryFeedback(diaryFeedbackId);
        diaryFeedback.update(content, userReaction);
        return diaryFeedback;
    }

    // 삭제
    public void deleteDiaryFeedback(Long diaryFeedbackId) {
        DiaryFeedback diaryFeedback = getDiaryFeedback(diaryFeedbackId);
        diaryFeedback.getDiary().changeDiaryFeedback(null);
    }

    // 분석
    public DiaryFeedback generateFeedback(Diary diary) {
        try {
            EmotionType emotionType = diary.getEmotion().getEmotionType();
            String content = diary.getTransformDiary().getContent();
            DiaryFeedbackJsonRequestDto diaryFeedbackJsonRequestDto = new DiaryFeedbackJsonRequestDto(emotionType, content);

            ObjectMapper objectMapper = new ObjectMapper();
            String inputJson = objectMapper.writeValueAsString(diaryFeedbackJsonRequestDto);
            log.info("파이썬에 전달할 JSON: {}", inputJson);

            String jsonOutput = PythonExecutor.execute("analyze_depression.py", inputJson);
            log.info("파이썬으로부터 받은 결과: {}", jsonOutput);

            DiaryFeedbackJsonResponseDto result = objectMapper.readValue(jsonOutput, DiaryFeedbackJsonResponseDto.class);
            String feedback = result.getFeedback();

            DiaryFeedback diaryFeedback = new DiaryFeedback();
            diaryFeedback.update(feedback, null);

            DiaryFeedback saved = saveDiaryFeedback(diaryFeedback);
            diary.changeDiaryFeedback(saved);
            return saved;
        } catch (Exception e) {
            log.error("우울증 분석 실패", e);
            throw new RuntimeException("우울증 분석 중 예외 발생", e);
        }


    }
}
