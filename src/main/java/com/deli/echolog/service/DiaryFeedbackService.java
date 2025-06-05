package com.deli.echolog.service;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.DiaryFeedback;
import com.deli.echolog.domain.EmotionType;
import com.deli.echolog.domain.UserReaction;
import com.deli.echolog.dto.diaryFeedback.DiaryFeedbackJsonRequestDto;
import com.deli.echolog.dto.diaryFeedback.DiaryFeedbackJsonResponseDto;
import com.deli.echolog.exception.DiaryFeedbackNotFoundException;
import com.deli.echolog.python.DiaryFeedbackSession;
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

    // 피드백 생성
    public DiaryFeedback generateFeedback(Diary diary) {
        try {
            EmotionType emotionType = diary.getEmotion().getEmotionType();
            String content = diary.getTransformDiary().getContent();

            log.info("파이썬에 전달할 감정: {}, 내용: {}", emotionType, content);

            // 파이썬 세션 호출
            String jsonOutput = DiaryFeedbackSession.analyze(emotionType.name(), content);
            log.info("파이썬으로부터 받은 결과: {}", jsonOutput);

            // 결과 파싱
            ObjectMapper objectMapper = new ObjectMapper();
            DiaryFeedbackJsonResponseDto result = objectMapper.readValue(jsonOutput, DiaryFeedbackJsonResponseDto.class);
            String feedback = result.getFeedback();

            // 저장 및 연관관계 설정
            DiaryFeedback diaryFeedback = new DiaryFeedback();
            diaryFeedback.update(feedback, null);
            DiaryFeedback saved = saveDiaryFeedback(diaryFeedback);
            diary.changeDiaryFeedback(saved);

            return saved;

        } catch (Exception e) {
            log.error("피드백 생성 실패", e);
            throw new RuntimeException("피드백 생성 중 예외 발생", e);
        }
    }
}
