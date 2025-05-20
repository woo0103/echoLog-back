package com.deli.echolog.service;

import com.deli.echolog.domain.*;
import com.deli.echolog.dto.emotion.EmotionJsonRequestDto;
import com.deli.echolog.dto.emotion.EmotionJsonResponseDto;
import com.deli.echolog.exception.DepressionNotFoundException;
import com.deli.echolog.exception.EmotionNotFoundException;
import com.deli.echolog.repository.DiaryRepository;
import com.deli.echolog.repository.EmotionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class EmotionService {

    // 생성자 주입
    private final EmotionRepository emotionRepository;
    private final DiaryRepository diaryRepository;

    @Transactional(readOnly = true)
    // 감정 조회
    public Emotion getEmotion(Long emotionId) {
        return emotionRepository.findById(emotionId)
                .orElseThrow(() -> new EmotionNotFoundException("emotion not found"));
    }


    // 감정 분석 정보 넘어온 거 그대로 저장
    public Emotion saveEmotion(Emotion emotion) {
        return emotionRepository.save(emotion);
    }

    // 감정 수정
    public Emotion updateEmotion(Long emotionId, EmotionType emotionType) {
        Emotion emotion = getEmotion(emotionId);
        emotion.update(emotionType);
        return emotion;
    }

    // 감정 삭제
    public void deleteEmotion(Long emotionId) {
        Emotion deleteEmotion = getEmotion(emotionId);
        deleteEmotion.getDiary().changeEmotion(null);
    }


    // 감정 분석
    public Emotion analyzeEmotion(Diary diary) {
        try {
            String content = diary.getTransformDiary().getContent();

            // Dto로 감싸기
            EmotionJsonRequestDto emotionJsonRequestDto = new EmotionJsonRequestDto(content);

            // ObjectMapper로 직렬화
            ObjectMapper objectMapper = new ObjectMapper();
            String inputJson = objectMapper.writeValueAsString(emotionJsonRequestDto);
            log.info("파이썬에 전달할 JSON: {}", inputJson);

            String jsonOutput = PythonExecutor.execute("analyze_emotion.py", inputJson);
            log.info("파이썬으로부터 받은 결과: {}", jsonOutput);

            // Json -> Dto로 파싱
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

