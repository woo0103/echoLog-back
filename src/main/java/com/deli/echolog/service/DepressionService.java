package com.deli.echolog.service;

import com.deli.echolog.domain.Depression;
import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.EmotionType;
import com.deli.echolog.dto.depression.DepressionJsonRequestDto;
import com.deli.echolog.dto.depression.DepressionJsonResponseDto;
import com.deli.echolog.exception.DepressionNotFoundException;
import com.deli.echolog.exception.DiaryNotFoundException;
import com.deli.echolog.repository.DepressionRepository;
import com.deli.echolog.repository.DiaryRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class DepressionService {

    private final DepressionRepository depressionRepository;

    // 우울증 분석 조회
    @Transactional(readOnly = true)
    public Depression getDepression(Long depressionId) {
        // id에 해당하는 일기가 없으면 예외 던짐
        return depressionRepository.findById(depressionId)
                .orElseThrow(() -> new DepressionNotFoundException("depression not found"));
    }



    // 우울증 분석 정보 넘어온 거 그대로 저장
    public Depression saveDepression(Depression depression) {
        return depressionRepository.save(depression);
    }

    // 우울증 분석 수정
    public Depression updateDepression(Long depressionId, Boolean result, Double emotionScore, Double depressionWordScore, Double phq9Score, Double gad7Score) {
        Depression depression = getDepression(depressionId);
        depression.update(result, emotionScore, depressionWordScore, phq9Score, gad7Score);
        return depression;
    }

    // 우울증 분석 삭제
    public void deleteDepression(Long depressionId) {
        Diary diary = getDepression(depressionId).getDiary();
        diary.changeDepression(null);
    }


    // 우울증 분석 메서드
    // 일기 정보를 받아서 우울증 분석 반환
    // 연관관계도 여기서 설정함
    public Depression analyzeDepression(Diary diary){
        try {
            EmotionType emotionType = diary.getEmotion().getEmotionType();
            String content = diary.getTransformDiary().getContent();
            DepressionJsonRequestDto depressionJsonRequestDto = new DepressionJsonRequestDto(emotionType, content);

            ObjectMapper objectMapper = new ObjectMapper();
            String inputJson = objectMapper.writeValueAsString(depressionJsonRequestDto);
            log.info("파이썬에 전달할 JSON: {}", inputJson);

            String jsonOutput = PythonExecutor.execute("analyze_depression.py", inputJson);
            log.info("파이썬으로부터 받은 결과: {}", jsonOutput);

            DepressionJsonResponseDto result = objectMapper.readValue(jsonOutput, DepressionJsonResponseDto.class);
            double emotionScore = result.getEmotionScore();
            double depressionWordScore = result.getDepressionWordScore();
            double phq9Score = result.getPhq9Score();
            double gad7Score = result.getGad7Score();
            boolean analyzedResult;

            // 우울증 판단 로직(임의)
            if (emotionScore + depressionWordScore + phq9Score + gad7Score >= 20.0) {
                analyzedResult = true;
            } else {
                analyzedResult = false;
            }

            // 연관관계 설정 전에 저장
            Depression depression = new Depression();
            depression.update(analyzedResult, emotionScore, depressionWordScore, phq9Score, gad7Score);
            Depression saved = saveDepression(depression);
            diary.changeDepression(saved);
            return saved;
        } catch (Exception e) {
            log.error("우울증 분석 실패", e);
            throw new RuntimeException("우울증 분석 중 예외 발생", e);
        }
    }
}
