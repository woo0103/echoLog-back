package com.deli.echolog.service;

import com.deli.echolog.domain.*;
import com.deli.echolog.dto.emotion.EmotionJsonResponseDto;
import com.deli.echolog.exception.EmotionNotFoundException;
import com.deli.echolog.python.EmotionSession;
import com.deli.echolog.repository.DiaryRepository;
import com.deli.echolog.repository.EmotionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class EmotionService {

    private final EmotionRepository emotionRepository;
    private final DiaryRepository diaryRepository;

    @Transactional(readOnly = true)
    public Emotion getEmotion(Long emotionId) {
        return emotionRepository.findById(emotionId)
                .orElseThrow(() -> new EmotionNotFoundException("emotion not found"));
    }

    public Emotion saveEmotion(Emotion emotion) {
        return emotionRepository.save(emotion);
    }

    public Emotion updateEmotion(Long emotionId, EmotionType emotionType) {
        Emotion emotion = getEmotion(emotionId);
        emotion.update(emotionType);
        return emotion;
    }

    public void deleteEmotion(Long emotionId) {
        Emotion deleteEmotion = getEmotion(emotionId);
        deleteEmotion.getDiary().changeEmotion(null);
    }

    public Emotion analyzeEmotion(Diary diary) {
        try {
            String content = diary.getTransformDiary().getContent();
            log.info("파이썬에 전달할 텍스트: {}", content);

            // 파이썬 분석 호출
            String jsonOutput = EmotionSession.analyze(content);
            log.info("파이썬 결과 수신: {}", jsonOutput);

            if (jsonOutput.contains("\"error\"")) {
                log.error("파이썬 오류 발생: {}", jsonOutput);
                throw new RuntimeException("감정 분석 파이썬 오류 발생: " + jsonOutput);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            EmotionJsonResponseDto result = objectMapper.readValue(jsonOutput, EmotionJsonResponseDto.class);
            EmotionType emotionType = result.getEmotionType();

            Emotion emotion = new Emotion();
            emotion.update(emotionType);

            Emotion saved = saveEmotion(emotion);
            diary.changeEmotion(saved);
            return saved;

        } catch (Exception e) {
            log.error("감정 분석 실패", e);
            throw new RuntimeException("감정 분석 중 예외 발생", e);
        }
    }
}
